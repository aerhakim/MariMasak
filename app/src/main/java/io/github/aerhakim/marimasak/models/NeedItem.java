
package io.github.aerhakim.marimasak.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NeedItem {

    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("thumb_item")
    @Expose
    private String thumbItem;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getThumbItem() {
        return thumbItem;
    }

    public void setThumbItem(String thumbItem) {
        this.thumbItem = thumbItem;
    }

}
