package com.developerssociety.bhargavreddy.paytminsiderassignment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.developerssociety.bhargavreddy.paytminsiderassignment.adapters.HomeAdapter;
import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper.ApiState;
import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.ActivityMainBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.FinalHomeData;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.HomeModel;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;
import com.developerssociety.bhargavreddy.paytminsiderassignment.utils.Commons;
import com.developerssociety.bhargavreddy.paytminsiderassignment.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private ActivityMainBinding activityMainBinding;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        //Viewmodel init
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeAdapter = new HomeAdapter(this);
        activityMainBinding.homeRecyclerView.setAdapter(homeAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        homeViewModel.getMutableLiveStateWrapper().observe(this, observer);

        getHomeScreenDetails();
    }

    private void getHomeScreenDetails() {
        homeViewModel.getHomeScreenApi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        homeViewModel.getMutableLiveStateWrapper().removeObserver(observer);
    }

    private Observer<ApiState<HomeModel>> observer = new Observer<ApiState<HomeModel>>() {
        @Override
        public void onChanged(ApiState<HomeModel> apiResponseApiState) {
            switch (apiResponseApiState.getStatus()) {
                case ERROR:
                    break;
                case LOADING:
                    break;
                case SUCCESS:
                    if (apiResponseApiState.getData() != null) {
                        populateData(apiResponseApiState.getData());
                    } else {
                        //No data screen..
                    }
                    break;
                case COMPLETED:

                    break;
            }
        }
    };

    private void populateData(HomeModel data) {
        int priority=Integer.MAX_VALUE;
        List<FinalHomeData> finalHomeDataList = new ArrayList<>();
        if (data.getBannerData() != null && data.getBannerData().size() != 0) {
            FinalHomeData finalHomeData = new FinalHomeData();
            finalHomeData.setBannerList(data.getBannerData());
            finalHomeData.setPriority(priority--);
            finalHomeData.setText("Banners");
            finalHomeData.setLayoutId(Commons.BANNER_LAYOUT_ID);
            finalHomeDataList.add(finalHomeData);
        }

        for (String val : data.getGroupsList()) {
            FinalHomeData finalHomeData = new FinalHomeData();
            finalHomeData.setText(val);
            finalHomeData.setLayoutId(Commons.EVENT_LAYOUT_ID);
            finalHomeData.setPriority(priority--);
            List<String> eventList = data.getListOb().getGroupWiseList().get(val);
            List<EventData> list = new ArrayList<>();
            for (String name : eventList) {
                list.add(data.getListOb().getMasterList().get(name));
            }
            finalHomeData.setEventDataList(list);

            finalHomeDataList.add(finalHomeData);
        }
        homeAdapter.setData(finalHomeDataList);
    }

    @Override
    public void onClick(View v) {
        homeViewModel.getHomeScreenApi();
    }
}