package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.CategoryId;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.DisplayDetails;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.GroupId;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

    @SerializedName("_id")
    @Expose
    private String id;

    @SerializedName("is_internal")
    @Expose
    private boolean isInternal;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("category_id")
    @Expose
    private CategoryId categoryId;

    @SerializedName("group_id")
    @Expose
    private GroupId groupId;

    @SerializedName("map_link")
    @Expose
    private String mapLink;

    @SerializedName("vertical_cover_image")
    @Expose
    private String verticalCoverImage;

    @SerializedName("priority")
    @Expose
    private int priority;

    @SerializedName("display_details")
    @Expose
    private DisplayDetails displayDetails;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isInternal() {
        return isInternal;
    }

    public void setInternal(boolean internal) {
        isInternal = internal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CategoryId getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(CategoryId categoryId) {
        this.categoryId = categoryId;
    }

    public GroupId getGroupId() {
        return groupId;
    }

    public void setGroupId(GroupId groupId) {
        this.groupId = groupId;
    }

    public String getMapLink() {
        return mapLink;
    }

    public void setMapLink(String mapLink) {
        this.mapLink = mapLink;
    }

    public String getVerticalCoverImage() {
        return verticalCoverImage;
    }

    public void setVerticalCoverImage(String verticalCoverImage) {
        this.verticalCoverImage = verticalCoverImage;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public DisplayDetails getDisplayDetails() {
        return displayDetails;
    }

    public void setDisplayDetails(DisplayDetails displayDetails) {
        this.displayDetails = displayDetails;
    }
}
