package com.ga.todoapp.controller;


import com.ga.todoapp.model.Category;
import com.ga.todoapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public void setCategoryRepository(CategoryService categoryService){
        this.categoryService= categoryService;
    }
    @PostMapping("/categories/")
    public Category createCategory(@RequestBody Category categoryObject){
        System.out.println("Service Calling this method ==>");
        return categoryService.createCategory(categoryObject);
    }


    @GetMapping("/categories")
    public List<Category> getCategories(){
        System.out.println("Calling getCategories");
        return categoryService.getCategories();
    }


    @GetMapping("/categories/{categoryId}")
    public Optional<Category> getCategories(@PathVariable Long categoryId){
        System.out.println("Calling getCategories");
        return categoryService.getCategory(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public Optional<Category> updateCategory(
            @PathVariable Long categoryId,
            @RequestBody Category category) {
        return categoryService.updateCategory(categoryId, category);
    }


    @DeleteMapping("/categories/{categoryId}")
    public Optional<Category> deleteCategory (@PathVariable Long categoryId){
        System.out.println("deleting getCategories");
        return categoryService.deleteCategory(categoryId);
    }




}
