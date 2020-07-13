package com.developerssociety.bhargavreddy.paytminsiderassignment.model;

public class ApiResponse<T> {

    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
