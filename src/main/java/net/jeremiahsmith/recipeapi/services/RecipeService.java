package net.jeremiahsmith.recipeapi.services;

import net.jeremiahsmith.recipeapi.models.Ingredient;
import net.jeremiahsmith.recipeapi.models.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes();
    Recipe getRecipeById(long id);
    List<Recipe> getRecipesByName(String name);
    void addRecipe(Recipe recipe);
    void deleteRecipe(Long recipeId);
    Recipe updateRecipe(Recipe recipe);
}
