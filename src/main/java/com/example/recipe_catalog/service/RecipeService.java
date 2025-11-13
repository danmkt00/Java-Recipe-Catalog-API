package com.example.recipe_catalog.service;

import com.example.recipe_catalog.dto.RecipeRequestDTO;
import com.example.recipe_catalog.dto.RecipeResponseDTO;
import com.example.recipe_catalog.model.Recipe;
import org.springframework.stereotype.Service;
import com.example.recipe_catalog.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository)
    {
        this.recipeRepository = recipeRepository;
    }

    public List<RecipeResponseDTO> getAllRecipes()
    {
        return recipeRepository.findAll().stream().map(recipe -> {
            RecipeResponseDTO recipeResponseDTO = new RecipeResponseDTO();
            recipeResponseDTO.setId(recipe.getId());
            recipeResponseDTO.setTitle(recipe.getTitle());
            recipeResponseDTO.setCategory(recipe.getCategory());
            recipeResponseDTO.setIngredients(recipe.getIngredients());
            return recipeResponseDTO;
        }).toList();
    }

    public RecipeResponseDTO createRecipe(RecipeRequestDTO requestDTO)
    {
        Recipe recipe = new Recipe();
        recipe.setTitle(requestDTO.getTitle());
        recipe.setCategory(requestDTO.getCategory());
        recipe.setIngredients(requestDTO.getIngredients());

        Recipe savedRecipe = recipeRepository.save(recipe);

        RecipeResponseDTO responseDTO = new RecipeResponseDTO();
        responseDTO.setId(savedRecipe.getId());
        responseDTO.setTitle(savedRecipe.getTitle());
        responseDTO.setIngredients(savedRecipe.getIngredients());
        responseDTO.setCategory(savedRecipe.getCategory());
        return responseDTO;
    }

    public List<RecipeResponseDTO> findRecipesByTitle(String title)
    {
        return recipeRepository.findByTitleContainingIgnoreCase(title).stream().map(recipe -> {
            RecipeResponseDTO dto = new RecipeResponseDTO();
            dto.setId(recipe.getId());
            dto.setTitle(recipe.getTitle());
            dto.setIngredients(recipe.getIngredients());
            dto.setCategory(recipe.getCategory());
            return dto;
        }).toList();
    }

    public List<RecipeResponseDTO> findRecipesByCategory(String category)
    {
        return recipeRepository.findByCategoryIgnoreCase(category).stream().map(recipe -> {
            RecipeResponseDTO dto = new RecipeResponseDTO();
            dto.setId(recipe.getId());
            dto.setTitle(recipe.getTitle());
            dto.setIngredients(recipe.getIngredients());
            dto.setCategory(recipe.getCategory());
            return dto;
        }).toList();
    }
}
