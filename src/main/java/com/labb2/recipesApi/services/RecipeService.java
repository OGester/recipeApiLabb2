package com.labb2.recipesApi.services;

import com.labb2.recipesApi.exception.EntityNotFoundException;
import com.labb2.recipesApi.models.Comment;
import com.labb2.recipesApi.models.Recipe;
import com.labb2.recipesApi.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
@Autowired
    RecipeRepository recipeRepository;
// skapa ett recept
    public Recipe addREcepie(Recipe recipe){
        return recipeRepository.save(recipe);
    }






    // lägga till kommentar till recept
    public Recipe addCommentToRecipe(String recipeId, Comment comment) {
        // Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(() -> new RuntimeException("Recipe not found"));
        return recipeRepository.findById(recipeId)
                .map(recipe -> {
                    recipe.addComment(comment);
                    return recipeRepository.save(recipe);
                }).orElseThrow(() -> new EntityNotFoundException("Recipe with id: " + recipeId + " was not found!"));
    }







}











