package com.labb2.recipesApi.repository;

import com.labb2.recipesApi.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
