package com.developerssociety.bhargavreddy.paytminsiderassignment.utils;

import android.content.res.Resources;

import java.util.List;

public class CommUtil {

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public  static <T> boolean isAllowed(List<T> o){
        return o!=null&&o.size()!=0;
    }

    public static String getRandomCity(){
        int i= (int) (System.currentTimeMillis()%4);
        switch (i){
            case 0:
                return "hyderabad";
            case 1:
                return "bangalore";
            case 2:
                return "mumbai";
            case 3:
                return "delhi";
            default:
                return "hyderabad";
        }
    }


}

