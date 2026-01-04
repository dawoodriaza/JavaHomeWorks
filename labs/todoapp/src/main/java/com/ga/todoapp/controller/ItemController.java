package com.ga.todoapp.controller;

import com.ga.todoapp.model.Category;
import com.ga.todoapp.model.Item;
import com.ga.todoapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService recipeService) {
        this.itemService = itemService;
    }

    @PostMapping("/categories/{categoryId}/items")
    public Item createItem(
            @PathVariable Long categoryId,
            @RequestBody Item itemObject
    ) {
        System.out.println("Calling createRecipe ==>");
        return itemService.createItem(categoryId, itemObject);
    }



    @GetMapping("/items")
    public List<Item> getItem(){
        System.out.println("Calling getCategories");
        return itemService.getItem();
    }

    @GetMapping("/items/{itemsid}")
    public Optional<Item> getItem(@PathVariable Long itemsid){
        System.out.println("Calling getCategories");
        return itemService.getItem(itemsid);
    }


    @PutMapping("/categories/{categoryId}/items/{recipeId}")
    public Optional<Item> updateItem(
            @PathVariable Long categoryId,
            @PathVariable Long itemsid,
            @RequestBody Item item) {
        return itemService.updateItem(categoryId, itemsid, item);
    }



    @DeleteMapping("/items/{itemsid}")
    public Optional<Item> deleteItem(
            @PathVariable Long itemsid){
        return itemService.deleteItem(itemsid);
    }

}