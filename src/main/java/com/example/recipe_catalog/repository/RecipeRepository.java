package com.example.recipe_catalog.repository;

import com.example.recipe_catalog.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContainingIgnoreCase(String title);
    List<Recipe> findByCategoryIgnoreCase(String category);
}
