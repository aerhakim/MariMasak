package io.github.aerhakim.marimasak.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Step {
    @SerializedName("step")
    @Expose
    private List<String> step = null;

    public List<String> getStep() {
        return step;
    }

    public void setStep(List<String> step) {
        this.step = step;
    }
}
