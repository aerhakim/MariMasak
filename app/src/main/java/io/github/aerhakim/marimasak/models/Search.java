package io.github.aerhakim.marimasak.models;

public class Search {


    String title, thumb, key, times, serving, difficulty;

    public String getDificulty() {
        return difficulty;
    }

    public void setDificulty(String dificulty) {
        this.difficulty = dificulty;
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getPortion() {
        return serving;
    }

    public void setPortion(String portion) {
        this.serving = portion;
    }


}
