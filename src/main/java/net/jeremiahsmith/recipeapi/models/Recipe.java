package net.jeremiahsmith.recipeapi.models;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {

    private Long id;
    private String name;
    private String description;
    private List<Ingredient> ingredientList;
    private List<RecipeStep> recipeSteps;
}
