package io.github.aerhakim.marimasak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCategory {

    @SerializedName("data")
    List<Category> categoryList;
    String error;

    public GetCategory(List<Category> categoryList, String error) {
        this.categoryList = categoryList;
        this.error = error;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public String getError() {
        return error;
    }


}