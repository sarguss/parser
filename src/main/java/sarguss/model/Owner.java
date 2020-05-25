package sarguss.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Owner {
    @JsonProperty("owner")
    boolean isOwner;

}
