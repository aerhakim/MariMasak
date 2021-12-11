package io.github.aerhakim.marimasak.models;

public class Recipe {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    String id,title, time, servings, difficulty;

    public Recipe(String id, String title, String time, String servings, String difficulty) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.servings = servings;
        this.difficulty = difficulty;

    }
}
