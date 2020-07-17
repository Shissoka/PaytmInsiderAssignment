package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.retrofit;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.HomeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiServiceClass {

    @GET("home?norm=1&filterBy=go-out")
    Call<HomeModel> getHomeApi(@Query("city")String city);

}
