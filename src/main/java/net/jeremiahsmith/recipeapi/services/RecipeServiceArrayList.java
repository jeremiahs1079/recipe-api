package net.jeremiahsmith.recipeapi.services;

import net.jeremiahsmith.recipeapi.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceArrayList implements RecipeService {

    private final ArrayList<Recipe> recipeArrayList;

    public RecipeServiceArrayList() {
        recipeArrayList = new ArrayList<>();
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeArrayList;
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return recipeArrayList.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    @Override
    public List<Recipe> getRecipesByName(String name) {
        return null;
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        recipeArrayList.add(recipe);

        return getRecipeById(recipe.getId()).isPresent();
    }

    @Override
    public boolean deleteRecipe(Long recipeId) {
        return recipeArrayList.removeIf(r -> r.getId().equals(recipeId));
    }

    @Override
    public Optional<Recipe> updateRecipe(Recipe recipe) {
        if(recipeArrayList.removeIf(r -> r.getId().equals(recipe.getId()))) {
            recipeArrayList.add(recipe);
        }

        return getRecipeById(recipe.getId());
    }
}
