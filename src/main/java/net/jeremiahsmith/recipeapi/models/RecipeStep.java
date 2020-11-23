package net.jeremiahsmith.recipeapi.models;

import lombok.Data;

import java.util.Map;

@Data
public class RecipeStep {

    private Long id;
    private int stepNumber;
    private String description;
    private Map<Ingredient, Measurement> neededIngredients;

}
