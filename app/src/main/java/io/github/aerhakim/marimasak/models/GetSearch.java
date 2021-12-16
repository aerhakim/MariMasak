package io.github.aerhakim.marimasak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSearch {

    @SerializedName("results")
    List<Search> searchList;
    String error;

    public GetSearch(List<Search> searchList, String error) {
        this.searchList = searchList;
        this.error = error;
    }

    public List<Search> getSearchList() {
        return searchList;
    }

    public String getError() {
        return error;
    }


}