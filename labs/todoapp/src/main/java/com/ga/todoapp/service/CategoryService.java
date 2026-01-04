package com.ga.todoapp.service;

import com.ga.todoapp.exception.InformationExistException;
import com.ga.todoapp.model.Category;
import com.ga.todoapp.model.User;
import com.ga.todoapp.repository.CategoryRepository;
import com.ga.todoapp.security.MyUserDetails;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepository categoryRepository;


    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository){
        this.categoryRepository= categoryRepository;

    }

    public static User getCurrentLoggedUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUser();
    }


    public Category createCategory(Category categoryObject){
        System.out.println("Service Calling this method ==>");
        Category category = categoryRepository.findByUserIdAndName(CategoryService.getCurrentLoggedUser().getId(),categoryObject.getName());

        if(category != null){

            throw new InformationExistException("category with name"+ category.getName()+ "already exist");
        }
        else {
            categoryObject.setUser(getCurrentLoggedUser());
            return categoryRepository.save(categoryObject);

        }
    }



    public List<Category> getCategories() {
        Long userId = getCurrentLoggedUser().getId();
        return categoryRepository.findByUserId(userId);
    }






    public Optional<Category> getCategory(Long categoryId){
        System.out.println("Service calling get Category id");
        Long userId = getCurrentLoggedUser().getId();
        Optional<Category> category = categoryRepository.findByIdAndUserId(categoryId, userId);

        if(category.isPresent()){
            return category;
        }
        else {
            throw new InformationExistException("Category with Id"+ categoryId+"not found");
        }

    }


    public Optional<Category> deleteCategory(Long categoryId){
        System.out.println("Service calling get Category id");
        Long userId = getCurrentLoggedUser().getId();
        Optional<Category> category = categoryRepository.findByIdAndUserId(userId, categoryId);
        if(category.isPresent()){
            categoryRepository.deleteById(categoryId);
            return category;
        }

        return Optional.empty();

    }

    public Optional<Category> updateCategory(Long categoryId, Category category) {
        if (category == null) {
            throw new InformationExistException("Request body is missing");
        }
        Long userId = getCurrentLoggedUser().getId();
        Category categoryExist = categoryRepository.findByIdAndUserId(userId, categoryId)
                .orElseThrow(() -> new InformationExistException(
                        "Category with Id " + categoryId + " not found"
                ));
        categoryExist.setName(category.getName());
        categoryExist.setDescription(category.getDescription());
        categoryExist.setUpdatedAt(LocalDateTime.now());

        return Optional.of(categoryRepository.save(categoryExist));
    }


}
