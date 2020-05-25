package sarguss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flat {
    @JsonProperty("id")
    private int id;

    @JsonProperty("info")
    private String info;

    @JsonProperty("link")
    private String link;

    public Flat(int id, String info, String link){
        this.id = id;
        this.info = info;
        this.link = link;
    }
}
