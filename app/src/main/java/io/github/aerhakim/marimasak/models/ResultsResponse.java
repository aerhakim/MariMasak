
package io.github.aerhakim.marimasak.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ResultsResponse {
    List<ResultsResponse> resultsResponses;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("results")
    @Expose
    Results results = null;


    public List<ResultsResponse> getResultsResponses() {
        return resultsResponses;
    }

    public void setResultsResponses(List<ResultsResponse> resultsResponses) {
        this.resultsResponses = resultsResponses;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }
}
