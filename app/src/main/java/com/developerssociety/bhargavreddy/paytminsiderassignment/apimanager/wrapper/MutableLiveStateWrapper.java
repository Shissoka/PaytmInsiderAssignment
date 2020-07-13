package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper;


import androidx.lifecycle.LiveData;


public class MutableLiveStateWrapper<T> extends LiveData<ApiState<T>> {

    public void postLoading() {
        setValue(new ApiState<T>().loading());
    }

    public void postError(Throwable throwable) {
        setValue(new ApiState<T>().error(throwable));
    }

    public void postSuccess(T data) {
        setValue(new ApiState<T>().success(data));
    }

    public void postStatusFalse(String message){
        setValue(new ApiState<T>().statusFalse(message));
    }

    public void postCompleted() {
        setValue(new ApiState<T>().completed());
    }
}
