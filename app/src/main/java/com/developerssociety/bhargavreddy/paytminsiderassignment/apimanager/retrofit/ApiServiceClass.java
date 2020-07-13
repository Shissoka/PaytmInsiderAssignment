package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.retrofit;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.ApiResponse;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.HomeModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServiceClass {

    @GET("home?norm=1&filterBy=go-out&city=mumbai")
    Call<ApiResponse<HomeModel>> getHomeApi();

}
