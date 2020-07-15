package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupId {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("icon_img")
    @Expose
    private String iconImg;
    @SerializedName("display_details")
    @Expose
    private DisplayDetails displayDetails;

    @SerializedName("slug")
    @Expose
    private String slug;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconImg() {
        return iconImg;
    }

    public void setIconImg(String iconImg) {
        this.iconImg = iconImg;
    }

    public DisplayDetails getDisplayDetails() {
        return displayDetails;
    }

    public void setDisplayDetails(DisplayDetails displayDetails) {
        this.displayDetails = displayDetails;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}