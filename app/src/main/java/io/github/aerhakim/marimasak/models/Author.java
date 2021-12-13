
package io.github.aerhakim.marimasak.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("datePublished")
    @Expose
    private String datePublished;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

}
