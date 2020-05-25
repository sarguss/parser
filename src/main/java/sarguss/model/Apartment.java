package sarguss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apartment {
    @JsonProperty("id")
    private int id;
    @JsonProperty("contact")
    private Owner owner;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("url")
    private String url;
}