package com.developerssociety.bhargavreddy.paytminsiderassignment.views;

import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public abstract class BaseActivity extends AppCompatActivity {


    public abstract void retryApi();


    private ProgressBar mProgressBar;
    public void setProgressBar(ProgressBar progressBar) {
        this.mProgressBar=progressBar;
    }

    public void showProgress(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress(){
        mProgressBar.setVisibility(View.GONE);
    }

    public void showSnackbar(View view,String message){
        Snackbar snackbar=Snackbar.make(view,message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retryApi();
            }
        });
        snackbar.show();
    }

}
