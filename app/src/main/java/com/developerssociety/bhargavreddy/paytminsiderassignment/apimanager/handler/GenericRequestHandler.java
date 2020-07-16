package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.handler;


import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper.MutableLiveStateWrapper;

import retrofit2.Call;
import retrofit2.Response;

public  class GenericRequestHandler<R> {


    public final  void doRequest(Call<R> responseCall, final MutableLiveStateWrapper<R> liveData) {
        //Loading the live data
        liveData.postLoading();
        responseCall.enqueue(new ApiCallback<R>() {

            @Override
            protected void handleResponseData(R response) {
                liveData.postSuccess(response);
            }

            @Override
            protected void handleResponseError(Response<R> response) {
                liveData.postFailure(response);
            }

            @Override
            protected void handleException(Throwable t) {
                liveData.postException(t);
            }

        });
    }
}
