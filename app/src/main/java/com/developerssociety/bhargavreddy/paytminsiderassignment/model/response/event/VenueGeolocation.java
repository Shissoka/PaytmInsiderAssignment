package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VenueGeolocation {

    @SerializedName("latitude")
    @Expose
    private Float latitude;
    @SerializedName("longitude")
    @Expose
    private Float longitude;

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}