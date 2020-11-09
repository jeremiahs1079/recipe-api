package net.jeremiahsmith.recipeapi.services;

import net.jeremiahsmith.recipeapi.models.Ingredient;
import net.jeremiahsmith.recipeapi.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    List<Recipe> getRecipes();
    Optional<Recipe> getRecipeById(Long id);
    List<Recipe> getRecipesByName(String name);
    boolean addRecipe(Recipe recipe);
    boolean deleteRecipe(Long recipeId);
    Optional<Recipe> updateRecipe(Recipe recipe);
}
