package com.ga.todoapp.repository;

import com.ga.todoapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    Item getItemByName(String name);
    Optional<Item> findByIdAndCategoryId(Long recipeId, Long categoryId);
}
