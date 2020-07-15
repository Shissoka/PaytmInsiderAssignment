package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowObject {

    @SerializedName("display")
    @Expose
    private String diplay;

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("type")
    @Expose
    private String type ;


    public String getDiplay() {
        return diplay;
    }

    public void setDiplay(String diplay) {
        this.diplay = diplay;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
