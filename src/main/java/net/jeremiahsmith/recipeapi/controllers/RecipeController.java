package net.jeremiahsmith.recipeapi.controllers;

import net.jeremiahsmith.recipeapi.models.Recipe;
import net.jeremiahsmith.recipeapi.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/${api.version}/${api.basePath}")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<?> getRecipes() {
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }

    @PostMapping("/recipes")
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe){
        this.recipeService.addRecipe(recipe);
        Recipe test = this.recipeService.getRecipeById(recipe.getId());

        if (test != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
