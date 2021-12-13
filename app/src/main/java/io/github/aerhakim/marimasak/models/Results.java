
package io.github.aerhakim.marimasak.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("servings")
    @Expose
    private String servings;
    @SerializedName("times")
    @Expose
    private String times;
    @SerializedName("dificulty")
    @Expose
    private String dificulty;
    @SerializedName("author")
    @Expose
    Author author = null;
    @SerializedName("desc")
    @Expose
    private String desc;
//    @SerializedName("needItem")
//    @Expose
//    NeedItem needItem = null;
//    @SerializedName("ingredient")
//    @Expose
//    Ingredient ingredient = null;
//
//    @SerializedName("step")
//    @Expose
//    Step step = null;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getDificulty() {
        return dificulty;
    }

    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

//    public NeedItem getNeedItem() {
//        return needItem;
//    }
//
//    public void setNeedItem(NeedItem needItem) {
//        this.needItem = needItem;
//    }

//    public Ingredient getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(Ingredient ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    public Step getStep() {
//        return step;
//    }
//
//    public void setStep(Step step) {
//        this.step = step;
//    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
