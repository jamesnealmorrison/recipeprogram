package com.jimmie.recipeprogram.domain;

import lombok.Data;

import java.util.Set;

@Data
public class Recipe {
    private Integer id;
    private String name;
    private String source;
    private Integer timesCooked;
    private Integer jimRanking;
    private Integer tracyRanking;
    private String page;
    private String notes;
    private Set<Ingredient> ingredients;
    private RecipeType recipeType;
    private Ethnicity ethnicity;
}
