package kz.springboot.SpringBootDemo.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class ItemRequest {

    @JsonAlias({"cnt_id", "country_id", "countryId"})
    private Long countryId;

    @JsonAlias({"item_name", "itemName"})
    private String itemName;

    @JsonAlias("amount")
    private int amount;

    @JsonAlias("price")
    private int price;

}
