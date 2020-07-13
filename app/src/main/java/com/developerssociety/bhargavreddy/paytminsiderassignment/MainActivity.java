package com.developerssociety.bhargavreddy.paytminsiderassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper.ApiState;
import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.ActivityMainBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.ApiResponse;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.HomeModel;
import com.developerssociety.bhargavreddy.paytminsiderassignment.viewmodel.HomeViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Viewmodel init
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        activityMainBinding.textView.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        homeViewModel.getMutableLiveStateWrapper().observe(this,observer);
        //Api call..
        homeViewModel.getHomeScreenApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        homeViewModel.getMutableLiveStateWrapper().removeObserver(observer);
    }

    private  Observer<ApiState<ApiResponse<HomeModel>>> observer=new  Observer<ApiState<ApiResponse<HomeModel>>>() {
        @Override
        public void onChanged(ApiState<ApiResponse<HomeModel>> apiResponseApiState) {
            switch (apiResponseApiState.getStatus()){
                case ERROR:
                    break;
                case LOADING:
                    break;
                case SUCCESS:
//                    List<String> tagsList = apiResponseApiState.getData().getData().getTagsList();
//                    Log.e("tahs list",tagsList.get(0));
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        homeViewModel.getHomeScreenApi();
    }
}