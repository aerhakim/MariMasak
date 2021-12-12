package io.github.aerhakim.marimasak.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDetail {

    @SerializedName("results")
    List<Detail> detailList;
    String error;

    public GetDetail(List<Detail> detailList, String error) {
        this.detailList = detailList;
        this.error = error;
    }

    public List<Detail> getDetailList() {
        return detailList;
    }

    public String getError() {
        return error;
    }


}