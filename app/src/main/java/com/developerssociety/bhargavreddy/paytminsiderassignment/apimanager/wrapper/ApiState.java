package com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ApiState<T> {

    @NonNull
    private DataStatus status;

    @Nullable
    private T data;

    @Nullable
    private Throwable error;

    private String message;

    public ApiState() {
        this.status = DataStatus.LOADING;
        this.data = null;
        this.error = null;
    }

    public ApiState<T> loading() {
        this.status = DataStatus.LOADING;
        this.data = null;
        this.error = null;
        return this;
    }


    public ApiState<T> success(@NonNull T data) {
        this.status = DataStatus.SUCCESS;
        this.data = data;
        this.error = null;
        return this;
    }


    public ApiState<T> completed() {
        this.status = DataStatus.COMPLETED;
        this.data = null;
        this.error = null;
        return this;
    }

    public ApiState<T> error(@NonNull Throwable error) {
        this.status = DataStatus.ERROR;
        this.data = null;
        this.error = error;
        this.message = null;
        return this;
    }

    public String getMessage(){
        return message;
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

    public enum DataStatus {
        LOADING,
        SUCCESS,
        COMPLETED,
        ERROR
    }
}