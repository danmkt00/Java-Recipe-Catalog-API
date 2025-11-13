package com.example.recipe_catalog.controller;

import com.example.recipe_catalog.dto.RecipeRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.recipe_catalog.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController
{
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService)
    {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<?> getAllRecipes()
    {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping
    public  ResponseEntity<?> addRecipe(@Valid @RequestBody RecipeRequestDTO requestDTO)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.createRecipe(requestDTO));
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchRecipes(@RequestParam String title)
    {
        return ResponseEntity.ok(recipeService.findRecipesByTitle(title));
    }

    @GetMapping("/category")
    public ResponseEntity<?> getRecipesByCategory(@RequestParam String category)
    {
        return ResponseEntity.ok(recipeService.findRecipesByCategory(category));
    }




}
