package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.retrofit;


import com.developerssociety.bhargavreddy.paytminsiderassignment.utils.Commons;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCreator {

    private String token = null;
    private ApiServiceClass apiServiceClass;
    private static RetrofitCreator retrofitCreator;

    private static final String BASE_URL = Commons.API_BASE_URL;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
    //Logging
    private static HttpLoggingInterceptor logging =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BASIC);


    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS);


    private RetrofitCreator() {
        createApiService();
    }


    public static RetrofitCreator getInstance() {
        if (retrofitCreator == null) {
            retrofitCreator = new RetrofitCreator();
        }
        return retrofitCreator;
    }

    private void createApiService() {
        Retrofit retrofit;
        if (!httpClient.interceptors().contains(logging)) {
            httpClient.addInterceptor(logging);
            httpClient.addNetworkInterceptor(new StethoInterceptor());
            builder.client(httpClient.build());
            retrofit = builder.build();
        } else {
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        apiServiceClass = retrofit.create(ApiServiceClass.class);
    }

    public ApiServiceClass getApiServiceClass() {
        return apiServiceClass;
    }

}