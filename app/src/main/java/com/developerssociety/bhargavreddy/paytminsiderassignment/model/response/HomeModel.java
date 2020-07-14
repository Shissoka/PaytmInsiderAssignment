package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeModel {
    @SerializedName("tags")
    @Expose
    private List<String> tagsList;

    @SerializedName("groups")
    @Expose
    private List<String> groupsList;

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    public List<String> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<String> groupsList) {
        this.groupsList = groupsList;
    }
}
