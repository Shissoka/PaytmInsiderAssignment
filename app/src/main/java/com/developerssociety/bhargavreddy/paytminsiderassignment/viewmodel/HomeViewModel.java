package com.developerssociety.bhargavreddy.paytminsiderassignment.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.ApiRepository;
import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.retrofit.RetrofitCreator;
import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper.MutableLiveStateWrapper;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.ApiResponse;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.HomeModel;

public class HomeViewModel extends AndroidViewModel {

    MutableLiveStateWrapper<ApiResponse<HomeModel>> mutableLiveStateWrapper = new MutableLiveStateWrapper<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getHomeScreenApi() {
        ApiRepository.getInstance().makeApiRequest(RetrofitCreator.getInstance().getApiServiceClass().getHomeApi(), mutableLiveStateWrapper);
    }

    public MutableLiveStateWrapper<ApiResponse<HomeModel>> getMutableLiveStateWrapper() {
        return mutableLiveStateWrapper;
    }

}
