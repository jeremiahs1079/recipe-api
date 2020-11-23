package net.jeremiahsmith.recipeapi.models;

import lombok.Data;

@Data
public class Measurement {

    private MeasurementUnit type;
    private float amount;
}
