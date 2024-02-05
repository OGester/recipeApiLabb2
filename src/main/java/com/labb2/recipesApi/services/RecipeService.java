package com.labb2.recipesApi.services;

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
}
