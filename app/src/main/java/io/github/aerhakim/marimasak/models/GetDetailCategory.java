package io.github.aerhakim.marimasak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDetailCategory {

    @SerializedName("results")
    List<DetailCategory> detailCategoryList;
    String error;

    public GetDetailCategory(List<DetailCategory> detailCategoryList, String error) {
        this.detailCategoryList = detailCategoryList;
        this.error = error;
    }

    public List<DetailCategory> getDetailCategoryList() {
        return detailCategoryList;
    }

    public String getError() {
        return error;
    }


}