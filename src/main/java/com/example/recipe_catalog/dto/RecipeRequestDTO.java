package com.example.recipe_catalog.dto;

import jakarta.validation.constraints.NotBlank;

public class RecipeRequestDTO {
    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Ingredients cannot be empty")
    private String ingredients;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(String ingredients)
    {
        this.ingredients = ingredients;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}
