package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.handler;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

abstract public class ApiCallback<T> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        Log.e("response", response.code() + " ");
        Log.e("response", response.isSuccessful() + " ");
        switch (response.code()) {
            case 200:
                handleResponseData(response.body());
                break;
            default:
                handleError(response);
        }
        handleProcessCompleted();
    }

    abstract protected void handleProcessCompleted();

    abstract protected void handleResponseData(T data);

    abstract protected void handleError(retrofit2.Response<T> response);

    abstract protected void handleException(Exception t);

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("on failure",t.getLocalizedMessage()+" null");
        handleProcessCompleted();
    }
}