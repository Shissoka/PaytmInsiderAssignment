package com.developerssociety.bhargavreddy.paytminsiderassignment.views;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.developerssociety.bhargavreddy.paytminsiderassignment.R;
import com.developerssociety.bhargavreddy.paytminsiderassignment.adapters.HomeAdapter;
import com.developerssociety.bhargavreddy.paytminsiderassignment.apimanager.wrapper.ApiState;
import com.developerssociety.bhargavreddy.paytminsiderassignment.databinding.ActivityMainBinding;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.FinalHomeData;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.HomeModel;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;
import com.developerssociety.bhargavreddy.paytminsiderassignment.utils.CommUtil;
import com.developerssociety.bhargavreddy.paytminsiderassignment.utils.Commons;
import com.developerssociety.bhargavreddy.paytminsiderassignment.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private ActivityMainBinding activityMainBinding;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.FullScreenTheme);
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        int flags = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
        window.getDecorView().setSystemUiVisibility(flags);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        setProgressBar(activityMainBinding.progressBar);

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
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private Disposable disposable;
    private Observer<ApiState<HomeModel>> observer = apiResponseApiState -> {
        switch (apiResponseApiState.getStatus()) {
            case LOADING:
                showProgress();
                break;
            case SUCCESS:
                if (apiResponseApiState.getData() != null) {
                    disposable = populateData(apiResponseApiState.getData());
                } else {
                    hideProgress();
                    //No data on screen...
                }
                break;
            case FAILURE:
                hideProgress();
                showSnackbar(activityMainBinding.getRoot(), "Bad Request or Error in parsing");
                break;
            case EXCEPTION:
                hideProgress();
                showSnackbar(activityMainBinding.getRoot(), "May be a connection isssue");
                break;
        }
    };


    private Disposable populateData(HomeModel homeData) {
        //processing data on Computation thread.
        return Observable.just(homeData)
                .map(data -> {
                    int priority = Integer.MAX_VALUE;
                    List<FinalHomeData> listInternal = new ArrayList<>();
                    //Adding banners
                    if (CommUtil.isAllowed(data.getBannerData())) {
                        FinalHomeData finalHomeData = new FinalHomeData();
                        finalHomeData.setText("Banners");
                        finalHomeData.setPriority(priority--);
                        finalHomeData.setLayoutId(Commons.BANNER_LAYOUT_ID);
                        finalHomeData.setBannerList(data.getBannerData());
                        listInternal.add(finalHomeData);
                    }


                    //Adding Feature Data
                    if (CommUtil.isAllowed(data.getFeaturedDataList())) {
                        FinalHomeData finalHomeData = new FinalHomeData();
                        finalHomeData.setLayoutId(Commons.EVENT_LAYOUT_ID);
                        finalHomeData.setText("Featured Events");
                        finalHomeData.setPriority(priority--);
                        finalHomeData.setEventDataList(data.getFeaturedDataList());
                        listInternal.add(finalHomeData);
                    }

                    //Adding data based on groups
                    if (CommUtil.isAllowed(data.getGroupsList())) {
                        for (String groupName : data.getGroupsList()) {
                            List<String> eventKeyList = data.getListOb().getGroupWiseList().get(groupName);
                            if (!CommUtil.isAllowed(eventKeyList))
                                continue;
                            List<EventData> list = new ArrayList<>();
                            for (String keyName : eventKeyList) {
                                list.add(data.getListOb().getMasterList().get(keyName));
                            }
                            FinalHomeData finalHomeData = new FinalHomeData();
                            finalHomeData.setText(groupName);
                            finalHomeData.setLayoutId(Commons.EVENT_LAYOUT_ID);
                            finalHomeData.setPriority(priority--);
                            finalHomeData.setEventDataList(list);

                            listInternal.add(finalHomeData);
                        }
                    }
                    return listInternal;
                }).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(finalList -> {
                    //setting final data on main thread.
                    homeAdapter.setData(finalList);
                    hideProgress();
                });

    }


    @Override
    public void onClick(View v) {
        homeViewModel.getHomeScreenApi();
    }

    @Override
    public void retryApi() {
        homeViewModel.getHomeScreenApi();
    }
}