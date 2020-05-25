package sarguss.httpClient;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import sarguss.model.Page;

import java.net.URI;

@Slf4j
public class FeignClient {

    private IClient iClient;

    public static final String HOST = "https://ak.api.onliner.by";
    public static final String MIN_PRICE = "200";
    public static final String MAX_PRICE = "250";

    public FeignClient() {
        this.iClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Slf4jLogger(IClient.class))
                .logLevel(Logger.Level.FULL)
                .target(IClient.class, HOST);
    }

    public Page getApartments(int pageId) {
        return iClient.getApartments(pageId, MIN_PRICE, MAX_PRICE);
    }

}
