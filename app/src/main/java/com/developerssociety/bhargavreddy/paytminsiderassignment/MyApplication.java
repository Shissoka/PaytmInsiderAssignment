package com.developerssociety.bhargavreddy.paytminsiderassignment;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;

public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
        Stetho.initializeWithDefaults(this);

    }
}
