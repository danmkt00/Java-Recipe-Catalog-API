package com.example.recipe_catalog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="recipes")
public class Recipe
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Ingredients is mandatory")
    @Size(max = 2000, message = "Ingredients cannot exceed 1000 characters")
    private String ingredients;

    @NotBlank(message = "Category is mandatory")
    private String category;

    public Recipe(){}

    public Recipe(String title, String ingredients, String category)
    {
        this.title = title;
        this.ingredients = ingredients;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
