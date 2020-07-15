package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Dates {

    @SerializedName("today")
    @Expose
    String today;

    @SerializedName("today_date_string")
    @Expose
    String todayDateString;

    @SerializedName("tomorrow")
    @Expose
    String tomorrow;


    @SerializedName("tomorrow_date_string")
    @Expose
    String tomorrowDate;


    @SerializedName("weekend")
    @Expose
    String weekend;

    @SerializedName("weekend_date_string")
    @Expose
    String weekendDateString;

    @SerializedName("next_weekend")
    @Expose
    String nextWeekend;


    @SerializedName("next_weekend_date_string")
    @Expose
    String nextWeekendDate;


}
