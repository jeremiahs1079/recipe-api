package net.jeremiahsmith.recipeapi.services;

import net.jeremiahsmith.recipeapi.models.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> getIngredients();
    Optional<Ingredient> getIngredientById(long id);
    List<Ingredient> getIngredientsByName(String name);
    boolean addIngredient(Ingredient ingredient);
    boolean deleteIngredient(Ingredient ingredient);
    Optional<Ingredient> updateIngredient(Ingredient ingredient);
}
