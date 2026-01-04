package com.ga.todoapp.repository;


import com.ga.todoapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String categoryName);
    Optional<Category> findByIdAndUserId(Long categoryId , long userId);
    List<Category> findByUserId(Long userId);

    Category findByUserIdAndName(Long userId, String categoryName);



}
