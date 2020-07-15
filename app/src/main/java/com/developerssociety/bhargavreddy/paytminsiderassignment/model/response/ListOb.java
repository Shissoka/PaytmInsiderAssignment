package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ListOb {

    @SerializedName("masterList")
    @Expose
    private Map<String, EventData> masterList;

    @SerializedName("groupwiseList")
    @Expose
    private Map<String, List<String>> groupWiseList;

    @SerializedName("categorywiseList")
    @Expose
    private Map<String, List<String>> categoryWiseList;

    public Map<String, EventData> getMasterList() {
        return masterList;
    }

    public void setMasterList(Map<String, EventData> masterList) {
        this.masterList = masterList;
    }

    public Map<String, List<String>> getGroupWiseList() {
        return groupWiseList;
    }

    public void setGroupWiseList(Map<String, List<String>> groupWiseList) {
        this.groupWiseList = groupWiseList;
    }

    public Map<String, List<String>> getCategoryWiseList() {
        return categoryWiseList;
    }

    public void setCategoryWiseList(Map<String, List<String>> categoryWiseList) {
        this.categoryWiseList = categoryWiseList;
    }
}
