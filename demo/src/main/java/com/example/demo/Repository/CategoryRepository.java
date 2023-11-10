package com.example.mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.mysql.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findCategoryByName(Strin categoryName);
    @Query(value = "SELECT * FROM category c WHERE c.name = :categoryName", nativeQuery = true)
    Category findCategoryByNameSQL(@Param("categoryName") String categoryName);
}
