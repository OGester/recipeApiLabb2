package com.labb2.recipesApi.controllers;

import com.labb2.recipesApi.exception.EntityNotFoundException;
import com.labb2.recipesApi.models.Comment;
import com.labb2.recipesApi.models.Recipe;
import com.labb2.recipesApi.services.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // POST
    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@Valid  @RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.addREcepie(recipe);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    // POST lägg till kommentar till recept
    @PostMapping("/{recipeId}/comments")
    public ResponseEntity<Recipe> addCommentToRecipe(@PathVariable String recipeId, @RequestBody Comment comment) {
        try {
            Recipe updatedRecipe = recipeService.addCommentToRecipe(recipeId, comment);
            return ResponseEntity.ok(updatedRecipe);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }







}
