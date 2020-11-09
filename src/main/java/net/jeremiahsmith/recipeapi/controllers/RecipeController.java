package net.jeremiahsmith.recipeapi.controllers;

import lombok.extern.slf4j.Slf4j;
import net.jeremiahsmith.recipeapi.exceptions.RecipeNotFoundException;
import net.jeremiahsmith.recipeapi.models.Recipe;
import net.jeremiahsmith.recipeapi.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/${api.version}/${api.basePath}/recipes")
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        log.debug("Constructing Recipe Controller");
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<?> getRecipes() {
        log.debug("GET /recipes");
        return new ResponseEntity<>(recipeService.getRecipes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe){
        log.debug("POST /recipes");

        if (this.recipeService.addRecipe(recipe)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{recipeId}")
    public ResponseEntity<?> getRecipeById(@PathVariable Long recipeId) throws RecipeNotFoundException {
        log.debug("GET /recipes/{}", recipeId);
        Optional<Recipe> recipeOptional = recipeService.getRecipeById(recipeId);
        if (recipeOptional.isPresent()) {
            log.debug("Recipe Found: {}", recipeOptional.get());
            return new ResponseEntity<>(recipeOptional.get(), HttpStatus.OK);
        }
        else {
            log.error("Recipe with id: {} not found", recipeId);
            throw new RecipeNotFoundException("Recipe Not Found");
        }
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity<?> deleteRecipeById(@PathVariable Long recipeId) throws RecipeNotFoundException, Exception {
        if(recipeService.getRecipeById(recipeId).isEmpty()) {
            log.error("Recipe with id: {} not found", recipeId);
            throw new RecipeNotFoundException("Recipe Not Found");
        }

        if(this.recipeService.deleteRecipe(recipeId)) {
            log.debug("Recipe with id: {} deleted", recipeId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        log.error("Unknown Error");
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{recipeId}")
    public ResponseEntity<?> putRecipeById(@PathVariable Long recipeId, @RequestBody Recipe recipe) throws RecipeNotFoundException {
        if (recipeService.getRecipeById(recipeId).isEmpty()) {
            log.error("Recipe with id: {} not found", recipeId);
            throw new RecipeNotFoundException("Recipe Not Found");
        }
        if (recipeService.updateRecipe(recipe).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
