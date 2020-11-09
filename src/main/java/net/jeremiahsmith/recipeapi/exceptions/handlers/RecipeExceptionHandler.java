package net.jeremiahsmith.recipeapi.exceptions.handlers;

import lombok.extern.slf4j.Slf4j;
import net.jeremiahsmith.recipeapi.exceptions.RecipeNotFoundException;
import net.jeremiahsmith.recipeapi.models.ErrorMessage;
import net.jeremiahsmith.recipeapi.models.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
@Slf4j
public class RecipeExceptionHandler {

    private final String CORRELATION_ID_HEADER = "Correlation-Id";

    @ExceptionHandler(RecipeNotFoundException.class)
    public final ResponseEntity<ErrorMessage> handleRecipeNotFoundException(RecipeNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage(ex.getMessage(), request.getHeader(CORRELATION_ID_HEADER)), HttpStatus.NOT_FOUND);
    }
}
