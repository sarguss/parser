package sarguss.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageProperties {
    @JsonProperty("current")
    private int currentPage;
    @JsonProperty("last")
    private int totalPage;
}
