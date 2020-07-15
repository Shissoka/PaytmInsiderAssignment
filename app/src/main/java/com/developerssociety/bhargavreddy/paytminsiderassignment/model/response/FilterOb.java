package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterOb {
    @SerializedName("show")
    @Expose
    private List<ShowObject> showObjectList;

    public List<ShowObject> getShowObjectList() {
        return showObjectList;
    }

    public void setShowObjectList(List<ShowObject> showObjectList) {
        this.showObjectList = showObjectList;
    }
}
