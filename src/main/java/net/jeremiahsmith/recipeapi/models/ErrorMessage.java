package net.jeremiahsmith.recipeapi.models;

import lombok.Data;

@Data
public class ErrorMessage {
    private final String message;
    private final String correlationId;
}
