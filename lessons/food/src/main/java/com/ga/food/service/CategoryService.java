package com.ga.food.service;

import com.ga.food.exception.InformationExistException;
import com.ga.food.model.Category;
import com.ga.food.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Category createCategory(Category categoryObject){
        System.out.println("Service Calling this method ==>");
        Category category = categoryRepository.findByName(categoryObject.getName());

        if(category != null){

            throw new InformationExistException("category with name"+ category.getName()+ "already exist");
        }
        else {
            categoryObject.setCreatedAt(LocalDateTime.now());
            return categoryRepository.save(categoryObject);

        }
    }

    public List<Category> getCategories(){
        System.out.println("Service calling get Categories");
        return categoryRepository.findAll();
    }


    public Optional<Category> getCategory(Long categoryId){
        System.out.println("Service calling get Category id");
        Optional<Category> category = categoryRepository.findById(categoryId);

        if(category.isPresent()){
            return category;
        }
        else {
            throw new InformationExistException("Category with Id"+ categoryId+"not found");
        }

    }


    public Optional<Category> deleteCategory(Long categoryId){
        System.out.println("Service calling get Category id");
        Optional<Category> category = categoryRepository.findById(categoryId);
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

        Category categoryExist = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new InformationExistException(
                        "Category with Id " + categoryId + " not found"
                ));

        categoryExist.setName(category.getName());
        categoryExist.setDiscription(category.getDiscription());
        categoryExist.setUpdatedAt(LocalDateTime.now());

        return Optional.of(categoryRepository.save(categoryExist));
    }


}
