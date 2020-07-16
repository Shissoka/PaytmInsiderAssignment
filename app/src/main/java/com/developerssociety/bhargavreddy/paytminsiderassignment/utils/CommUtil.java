package com.developerssociety.bhargavreddy.paytminsiderassignment.utils;

import android.content.res.Resources;

public class CommUtil {

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}

