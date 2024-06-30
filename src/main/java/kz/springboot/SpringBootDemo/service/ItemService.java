package kz.springboot.SpringBootDemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import kz.springboot.SpringBootDemo.entities.Categories;
import kz.springboot.SpringBootDemo.entities.Countries;
import kz.springboot.SpringBootDemo.entities.ShopItems;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ItemService {

    public ShopItems addItem(ShopItems item);
    List<ShopItems> getAllItems();
    ShopItems getItem(Long id);
    void deleteItem(Long id);
    ShopItems saveItem(ShopItems item);

    List<Countries> getAllCountries();
    Countries addCountry(Countries country);
    Countries saveCountry(Countries country) throws JsonProcessingException;
    Countries getCountry(Long id);

    List<Categories> getAllCategories();
    Categories getCategory(Long id);
    Categories saveCategory(Categories category);
    Categories addCategory(Categories category);

}
