package sarguss.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ViewedList {
    @JsonProperty("id")
    private Set<Integer> set;

    public void add(int id){
        set.add(id);
    }
}
