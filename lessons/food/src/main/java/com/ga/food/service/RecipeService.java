package com.ga.food.service;

import com.ga.food.exception.InformationNotFoundException;

import com.ga.food.exception.InformationNotFoundException;
import com.ga.food.model.Category;
import com.ga.food.model.Recipe;
import com.ga.food.repository.CategoryRepository;
import com.ga.food.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setRecipeRepository(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(Long categoryId, Recipe recipe) {
        System.out.println("Service calling createRecipe ==>");

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException(
                        "Category with id " + categoryId + " does not exist"
                ));

        recipe.setCategory(category);
        return recipeRepository.save(recipe);
    }



    public List<Recipe> getRecipe(){
        System.out.println("Service calling get Categories");
        return recipeRepository.findAll();
    }


    public Optional<Recipe> getRecipe(Long recipeId){
        System.out.println("Service calling get recipe id");
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if(recipe.isPresent()){
            return recipe;
        }
        else {
            throw new InformationNotFoundException("Category with Id"+ recipeId+"not found");
        }

    }

    public Optional<Recipe> updateRecipe(Long categoryId, Long recipeId, Recipe updatedRecipe) {

        System.out.println("Service calling updateRecipe");

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationNotFoundException(
                        "Category with id " + categoryId + " does not exist"
                ));
        Recipe existingRecipe = recipeRepository
                .findByIdAndCategoryId(recipeId, categoryId)
                .orElseThrow(() -> new InformationNotFoundException(
                        "Recipe with id " + recipeId + " not found in category " + categoryId
                ));
        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setIngredients(updatedRecipe.getIngredients());
        existingRecipe.setPortions(updatedRecipe.getPortions());
        existingRecipe.setCategory(category);
        return Optional.of(recipeRepository.save(existingRecipe));
    }


    public Optional<Recipe> deleteRecipe(Long recipeId){
        System.out.println("Service calling get recipeId id");
        Optional<Recipe> recipe = recipeRepository.findById(recipeId);
        if(recipe.isPresent()){
            recipeRepository.deleteById(recipeId);
            return recipe;
        }

        return Optional.empty();

    }


}