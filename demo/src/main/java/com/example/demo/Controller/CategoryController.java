package com.example.mysql.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.mysql.repository.CategoryRepository;
import com.example.mysql.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @GetMapping("/byName/{categoryName}")
    public Category getCategoryByName(@PathVariable String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @GetMapping("/byNameSQL/{categoryName}")
    public Category getCategoryByNameSQL(@PathVariable String categoryName){
        return categoryRepository.findCategoryByNameSQL(categoryName);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
    }
}