package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper;


import androidx.lifecycle.LiveData;

import retrofit2.Response;


public class MutableLiveStateWrapper<T> extends LiveData<ApiState<T>> {

    public void postLoading() {
        setValue(new ApiState<T>().loading());
    }

    public void postException(Throwable throwable) {
        setValue(new ApiState<T>().Exception(throwable));
    }

    public void postFailure(Response<T> responseError) {
        setValue(new ApiState<T>().failure(responseError));
    }

    public void postSuccess(T data) {
        setValue(new ApiState<T>().success(data));
    }
}
