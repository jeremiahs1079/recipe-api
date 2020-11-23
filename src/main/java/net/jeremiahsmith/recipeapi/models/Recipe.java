package net.jeremiahsmith.recipeapi.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Recipe {

    private Long id;
    private String name;
    private String description;
    private Map<Ingredient, Measurement> ingredientList;
    private List<RecipeStep> recipeSteps;
}
