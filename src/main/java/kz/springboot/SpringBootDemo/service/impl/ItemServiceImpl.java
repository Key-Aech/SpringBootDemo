package kz.springboot.SpringBootDemo.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.springboot.SpringBootDemo.entities.Categories;
import kz.springboot.SpringBootDemo.entities.Countries;
import kz.springboot.SpringBootDemo.entities.ShopItems;
import kz.springboot.SpringBootDemo.repositories.CategoryRepository;
import kz.springboot.SpringBootDemo.repositories.CountryRepository;
import kz.springboot.SpringBootDemo.repositories.ShopItemRepository;
import kz.springboot.SpringBootDemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ItemServiceImpl  implements ItemService {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ShopItems addItem(ShopItems item) {
        return shopItemRepository.save(item);
    }

    @Override
    public List<ShopItems> getAllItems() {
        return shopItemRepository.findAllByAmountGreaterThanOrderByPriceDesc(0);
    }

    @Override
    public ShopItems getItem(Long id) {return shopItemRepository.findById(id).orElse(null);}

    @Override
    public void deleteItem(Long id) {
        shopItemRepository.deleteById(id);
    }

    @Override
    public ShopItems saveItem(ShopItems item) {
        return shopItemRepository.save(item);
    }

    @Override
    public List<Countries> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Countries addCountry(Countries country) {return countryRepository.save(country);}

    @Override
    public Countries saveCountry(Countries country) throws JsonProcessingException {

        mapper.writeValueAsString(country);
        return countryRepository.save(country);

    }

    @Override
    public Countries getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categories> getAllCategories() {return categoryRepository.findAll();}

    @Override
    public Categories getCategory(Long id) {return categoryRepository.findById(id).orElse(null);}

    @Override
    public Categories saveCategory(Categories category) {return categoryRepository.save(category);}

    @Override
    public Categories addCategory(Categories category) {return categoryRepository.save(category);}


}