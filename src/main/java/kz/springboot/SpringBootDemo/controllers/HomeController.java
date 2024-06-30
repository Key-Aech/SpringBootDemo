package kz.springboot.SpringBootDemo.controllers;

import kz.springboot.SpringBootDemo.entities.Categories;
import kz.springboot.SpringBootDemo.entities.Countries;
import kz.springboot.SpringBootDemo.entities.ShopItems;
import kz.springboot.SpringBootDemo.models.CategoryRequest;
import kz.springboot.SpringBootDemo.models.ItemRequest;
import kz.springboot.SpringBootDemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private ItemService itemService;

    @ResponseBody
    @GetMapping(value = "/")
    public List<ShopItems> index(){

        return itemService.getAllItems();

    }

//    @PostMapping(value = "/add-item")
//    public String addItem(@RequestParam(name = "country_id", defaultValue = "0") Long id,
//                          @RequestParam(name = "item_name", defaultValue = "No Item") String name,
//                          @RequestParam(name = "item_price", defaultValue = "0") int price,
//                          @RequestParam(name = "item_amount", defaultValue = "0") int amount){
//
//        Countries cnt = itemService.getCountry(id);
//
//        if (cnt != null){
//
//            ShopItems item = new ShopItems(null, name, price, amount, cnt);
//
////            item.setName(name);
////            item.setPrice(price);
////            item.setAmount(amount);
////            item.setCountry(cnt);
//            itemService.addItem(item);
//
//        }
//
//        return "redirect:/";
//
//    }

    @PostMapping("/v2/add-item")
    public String addItem(@RequestBody ItemRequest request){



        Countries cnt = itemService.getCountry(request.getCountryId());

        if (cnt != null){
            return "redirect:/";

//            ShopItems item = new ShopItems(null, request.getItemName(), request.getPrice(), request.getAmount(), cnt, categories);
//            itemService.addItem(item);

        }

        return "redirect:/";

    }


    @ResponseBody
    @GetMapping(value = "/details/{id}")
    public ShopItems details(@PathVariable(name="id") Long id){

        return itemService.getItem(id);

    }

    @PostMapping(value = "/saveItem")
    public String saveItem(@RequestParam(name = "id", defaultValue = "0") Long id,
                           @RequestParam(name = "county_id", defaultValue = "0") Long countryId,
                           @RequestParam(name = "item_name", defaultValue = "No Item") String name,
                           @RequestParam(name = "item_price", defaultValue = "0") int price,
                           @RequestParam(name = "item_amount", defaultValue = "0") int amount){

        ShopItems item = itemService.getItem(id);

        if(item != null){

            Countries cnt = itemService.getCountry(countryId);
            if(cnt!= null){

                item.setName(name);
                item.setPrice(price);
                item.setAmount(amount);
                item.setCountry(cnt);
                itemService.saveItem(item);

            }
        }

        return "redirect:/";

    }

    @PostMapping(value = "/deleteItem")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id){

        itemService.deleteItem(id);

        return "redirect:/";

    }

    @PostMapping(value = "/assign-category")
    public String assignCategory(@RequestBody CategoryRequest request){

        Categories cat = itemService.getCategory(request.getCategoryId());
        if (cat != null) {

            ShopItems item = itemService.getItem(request.getItemId());
            if (item != null) {

                List<Categories> categories = itemService.getItem(request.getItemId()).getCategories();
                if (categories == null) {
                    categories = new ArrayList<>();
                }
//                if(categories.contains(cat)){
//
//                }
                categories.add(cat);

                item.setCategories(categories);

                itemService.saveItem(item);

//                return "redirect:/details/" + request.getItemId();
            }
        }

        return "redirect:/";

    }
}
