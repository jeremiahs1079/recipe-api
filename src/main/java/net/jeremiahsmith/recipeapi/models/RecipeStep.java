package net.jeremiahsmith.recipeapi.models;

import lombok.Data;

import java.util.List;

@Data
public class RecipeStep {

    private Long id;
    private int stepNumber;
    private String description;
    private List<Ingredient> neededIngredients;

}
