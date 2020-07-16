package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import androidx.annotation.Nullable;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;

import java.util.List;

public class FinalHomeData {
    private int layoutId;

    private int priority;
    private String text;

    @Nullable
    private String description;

    @Nullable
    List<Banner> bannerList;

    @Nullable
    List<EventData> eventDataList;

    @Nullable
    List<DigitalEventGroupObject> digitalEventGroupObjectList;

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

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public List<DigitalEventGroupObject> getDigitalEventGroupObjectList() {
        return digitalEventGroupObjectList;
    }

    public void setDigitalEventGroupObjectList(@Nullable List<DigitalEventGroupObject> digitalEventGroupObjectList) {
        this.digitalEventGroupObjectList = digitalEventGroupObjectList;
    }
}
