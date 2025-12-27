package com.ga.food.controller;

import com.ga.food.model.Category;
import com.ga.food.model.Recipe;
import com.ga.food.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/categories/{categoryId}/recipes")
    public Recipe createRecipe(
            @PathVariable Long categoryId,
            @RequestBody Recipe recipeObject
    ) {
        System.out.println("Calling createRecipe ==>");
        return recipeService.createRecipe(categoryId, recipeObject);
    }



    @GetMapping("/recipes")
    public List<Recipe> getRecipe(){
        System.out.println("Calling getCategories");
        return recipeService.getRecipe();
    }

    @GetMapping("/recipes/{recipeId}")
    public Optional<Recipe> getRecipe(@PathVariable Long recipeId){
        System.out.println("Calling getCategories");
        return recipeService.getRecipe(recipeId);
    }


    @PutMapping("/categories/{categoryId}/recipes/{recipeId}")
    public Optional<Recipe> updateRecipe(
            @PathVariable Long categoryId,
            @PathVariable Long recipeId,
            @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(categoryId, recipeId, recipe);
    }



    @DeleteMapping("/recipes/{recipeId}")
    public Optional<Recipe> deleteRecipe(
            @PathVariable Long recipeId){
        return recipeService.deleteRecipe(recipeId);
    }

}