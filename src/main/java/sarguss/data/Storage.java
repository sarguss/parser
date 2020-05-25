package sarguss.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import sarguss.httpClient.FeignClient;
import sarguss.model.Apartment;
import sarguss.model.Flat;
import sarguss.model.Page;

import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class Storage {
    private final static String FOLDER_PATH = "C:/Users/sergeyma/Desktop/Apartments/";
    ObjectMapper mapper = new ObjectMapper();
    List<Flat> ownerFlats = new ArrayList<>();
    List<Flat> agencyFlats = new ArrayList<>();
    Date date = new Date();

    @SneakyThrows
    private ViewedList getList() {
        return mapper.readValue(Paths.get(FOLDER_PATH+"viewedList.json").toFile(), ViewedList.class);
    }

    @SneakyThrows
    private void markAsViewed(List<Integer> ids) {
        ViewedList list = getList();
        for (Integer id : ids) {
            list.add(id);
        }
        mapper.writeValue(Paths.get(FOLDER_PATH+"viewedList.json").toFile(), list);
    }

    public void update(FeignClient client) {
        Set<Integer> viewed = getList().getSet();
        int n = 1;
        for (int i = 1; i < (n + 1); i++) {
            log.info("get page #" + i);
            Page page = client.getApartments(i);
            n = page.getPageProperties().getTotalPage();
            for (Apartment apartment : page.getApartmentList()) {
                int id = apartment.getId();
                if (viewed.contains(id)) {
                    break;
                }
                Flat flat = new Flat(id, apartment.getCreated_at(), apartment.getUrl());
                if (apartment.getOwner().isOwner()) {
                    ownerFlats.add(flat);
                } else {
                    agencyFlats.add(flat);
                }
            }
        }
        writeToFile(agencyFlats, "a");
        writeToFile(ownerFlats, "owner");
    }
    @SneakyThrows
    private void writeToFile(List<Flat> list, String owner){
        markAsViewed(list.stream().map(Flat::getId).collect(Collectors.toList()));
        DateFormat df = new SimpleDateFormat("MMM-dd_HH-mm");
        String fileName = df.format(date.getTime())+ "_" + owner + ".json";
        mapper.writeValue(Paths.get(FOLDER_PATH+fileName).toFile(), list);
    }
}
