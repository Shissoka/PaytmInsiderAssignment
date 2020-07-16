package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import androidx.annotation.Nullable;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;

import java.util.List;

public class FinalHomeData {
    //    layoutId 1 for banner
    //else for others..
    private int layoutId;

    private int priority;
    private String text;

    @Nullable
    List<Banner> bannerList;

    @Nullable
    List<EventData> eventDataList;

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    @Nullable
    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String  getText() {
        return text;
    }

    public void setText(String  text) {
        this.text = text;
    }

    @Nullable
    public List<EventData> getEventDataList() {
        return eventDataList;
    }

    public void setEventDataList(@Nullable List<EventData> eventDataList) {
        this.eventDataList = eventDataList;
    }
}
