package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import retrofit2.Response;

public class ApiState<T> {

    @NonNull
    private DataStatus status;

    @Nullable
    private T data;

    @Nullable
    private Response<T> responseError;


    @Nullable
    private Throwable error;


    public ApiState() {
        this.status = DataStatus.LOADING;
        this.data = null;
        this.error = null;
        this.responseError = null;
    }

    public ApiState<T> loading() {
        this.status = DataStatus.LOADING;
        this.data = null;
        this.error = null;
        this.responseError = null;
        return this;
    }


    public ApiState<T> success(@NonNull T data) {
        this.status = DataStatus.SUCCESS;
        this.data = data;
        this.error = null;
        this.responseError = null;
        return this;
    }


    public ApiState<T> failure(@NonNull Response<T> responseError) {
        this.status = DataStatus.FAILURE;
        this.data = null;
        this.responseError = responseError;
        this.error = null;
        return this;
    }


    public ApiState<T> Exception(@NonNull Throwable error) {
        this.status = DataStatus.EXCEPTION;
        this.data = null;
        this.error = error;
        this.responseError = null;
        return this;
    }


    @NonNull
    public DataStatus getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public Throwable getError() {
        return error;
    }

    @Nullable
    public Response<T> getResponseError() {
        return responseError;
    }

    public enum DataStatus {
        LOADING,
        SUCCESS,
        EXCEPTION,
        FAILURE
    }
}