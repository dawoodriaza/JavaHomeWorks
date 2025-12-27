package com.ga.food.repository;

import com.ga.food.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository  extends JpaRepository<Recipe,Long> {
    Recipe findByName(String recipeName);
    Optional<Recipe> findByIdAndCategoryId(Long recipeId, Long categoryId);
}