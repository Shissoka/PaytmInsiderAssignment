package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager;


import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.handler.GenericRequestHandler;
import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper.MutableLiveStateWrapper;

import retrofit2.Call;

public class ApiRepository  {

    private static ApiRepository apiRepository;


    public static ApiRepository getInstance() {
        if (apiRepository == null) {
            apiRepository = new ApiRepository();
        }
        return apiRepository;
    }


    //Passing generic response data..
    public <T>  void  makeApiRequest(Call<T> responseCall, MutableLiveStateWrapper<T> mutableLiveStateWrapper){
        GenericRequestHandler<T> genericRequestHandler=new GenericRequestHandler<>();
        genericRequestHandler.doRequest(responseCall,mutableLiveStateWrapper);
    }

}
