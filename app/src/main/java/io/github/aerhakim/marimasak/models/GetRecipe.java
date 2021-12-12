package io.github.aerhakim.marimasak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRecipe {

    @SerializedName("results")
    List<Recipe> recipeList;
    String error;

    public GetRecipe(List<Recipe> recipeList, String error) {
        this.recipeList = recipeList;
        this.error = error;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public String getError() {
        return error;
    }


}