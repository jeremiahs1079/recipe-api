package net.jeremiahsmith.recipeapi.services;

import net.jeremiahsmith.recipeapi.models.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getIngredients();
    Ingredient getIngredientById(long id);
    List<Ingredient> getIngredientsByName(String name);
    Ingredient addIngredient(Ingredient ingredient);
    void deleteIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient);
}
