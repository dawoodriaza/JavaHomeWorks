package com.ga.todoapp.service;


import com.ga.todoapp.exception.InformationExistException;
import com.ga.todoapp.exception.InformationNotFoundException;
import com.ga.todoapp.model.Category;
import com.ga.todoapp.model.Item;
import com.ga.todoapp.repository.CategoryRepository;
import com.ga.todoapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

private CategoryRepository categoryRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item createItem( Long categoryId,Item itemObject){
        System.out.println("Item Create iTEM");
        Item item = itemRepository.getItemByName(itemObject.getName());

        if(item!= null){
            throw new InformationExistException("Item with name" + item.getName() + "already exists");
        }
        else{
            return itemRepository.save(itemObject);
        }
    }



    public List<Item> getItem(){
        System.out.println("Service calling get Categories");
        return itemRepository.findAll();
    }


    public Optional<Item> getItem(Long itemId){
        System.out.println("Service calling get item id");
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            return item;
        }
        else {
            throw new InformationNotFoundException("Category with Id"+ itemId+"not found");
        }

    }

    public Optional<Item> updateItem(Long categoryId, Long itemId, Item updatedItem) {

        System.out.println("Service calling itemId");

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException(
                        "Category with id " + categoryId + " does not exist"
                ));
        Item existingItem = itemRepository
                .findByIdAndCategoryId(itemId, categoryId)
                .orElseThrow(() -> new InformationNotFoundException(
                        "iteM with id " + itemId  + " not found in category " + categoryId
                ));
        existingItem.setName(updatedItem.getName());
        existingItem.setCategory(category);
        return Optional.of(itemRepository.save(existingItem));
    }


    public Optional<Item> deleteItem(Long itemId){
        System.out.println("Service calling get itemId id");
        Optional<Item> item = itemRepository.findById(itemId);
        if(item.isPresent()){
            itemRepository.deleteById(itemId);
            return item;
        }

        return Optional.empty();

    }


}
