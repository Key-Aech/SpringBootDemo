package kz.springboot.SpringBootDemo.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class CategoryRequest {
    @JsonAlias({"item_id", "itemId"})
    private Long itemId;
    @JsonAlias({"category_id", "categoryId"})
    private Long categoryId;
}
