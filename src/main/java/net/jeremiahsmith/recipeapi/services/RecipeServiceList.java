package net.jeremiahsmith.recipeapi.services;

import net.jeremiahsmith.recipeapi.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceList implements RecipeService {

    private ArrayList<Recipe> recipeArrayList;

    public RecipeServiceList() {
        recipeArrayList = new ArrayList<>();
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeArrayList;
    }

    @Override
    public Recipe getRecipeById(long id) {
        Optional<Recipe> recipe = recipeArrayList.stream().filter(r -> r.getId() == id).findFirst();
        return recipe.isPresent() ? recipe.get() : null;
    }

    @Override
    public List<Recipe> getRecipesByName(String name) {
        return null;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeArrayList.add(recipe);
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        recipeArrayList.removeIf(r -> r.getId() == recipeId);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return null;
    }
}
