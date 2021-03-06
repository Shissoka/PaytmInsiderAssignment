package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag {

    @SerializedName("is_featured")
    @Expose
    private Boolean isFeatured;
    @SerializedName("is_carousel")
    @Expose
    private Boolean isCarousel;
    @SerializedName("is_pick")
    @Expose
    private Boolean isPick;
    @SerializedName("is_primary_interest")
    @Expose
    private Boolean isPrimaryInterest;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("tag_id")
    @Expose
    private String tagId;

    public Boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(Boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    public Boolean getIsCarousel() {
        return isCarousel;
    }

    public void setIsCarousel(Boolean isCarousel) {
        this.isCarousel = isCarousel;
    }

    public Boolean getIsPick() {
        return isPick;
    }

    public void setIsPick(Boolean isPick) {
        this.isPick = isPick;
    }

    public Boolean getIsPrimaryInterest() {
        return isPrimaryInterest;
    }

    public void setIsPrimaryInterest(Boolean isPrimaryInterest) {
        this.isPrimaryInterest = isPrimaryInterest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

}