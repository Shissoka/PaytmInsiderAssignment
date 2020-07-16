package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response;

import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.DisplayDetails;
import com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event.EventData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class HomeModel {
    @SerializedName("tags")
    @Expose
    private List<String> tagsList;

    @SerializedName("groups")
    @Expose
    private List<String> groupsList;


    @SerializedName("filters")
    @Expose
    Map<String,FilterOb> filters;

    @SerializedName("sorters")
    @Expose
    Map<String,List<ShowObject>> sorters;

    @SerializedName("list")
    @Expose
    ListOb  listOb;

    @SerializedName("picks")
    @Expose
    ListOb  picksList;

    @SerializedName("Popular")
    @Expose
    List<EventData> popularEventDataList;

    @SerializedName("text")
    @Expose
    Map<String, DisplayDetails> dynamicText;

    @SerializedName("featured")
    @Expose
    List<EventData> featuredDataList;


    @SerializedName("dates")
    @Expose
    Dates dates;

    @SerializedName("banners")
    @Expose
    List<Banner> bannerData;

    @SerializedName("digital_event_groups")
    @Expose
    private List<DigitalEventGroupObject> digitalEventGroupObjectList;

    @SerializedName("digital_event_groups_description")
    @Expose
    private String digitalEventsDecription;

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }

    public List<String> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<String> groupsList) {
        this.groupsList = groupsList;
    }

    public Map<String, FilterOb> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, FilterOb> filters) {
        this.filters = filters;
    }

    public Map<String, List<ShowObject>> getSorters() {
        return sorters;
    }

    public void setSorters(Map<String, List<ShowObject>> sorters) {
        this.sorters = sorters;
    }

    public ListOb getListOb() {
        return listOb;
    }

    public void setListOb(ListOb listOb) {
        this.listOb = listOb;
    }

    public ListOb getPicksList() {
        return picksList;
    }

    public void setPicksList(ListOb picksList) {
        this.picksList = picksList;
    }

    public List<EventData> getPopularEventDataList() {
        return popularEventDataList;
    }

    public void setPopularEventDataList(List<EventData> popularEventDataList) {
        this.popularEventDataList = popularEventDataList;
    }



    public List<EventData> getFeaturedDataList() {
        return featuredDataList;
    }

    public void setFeaturedDataList(List<EventData> featuredDataList) {
        this.featuredDataList = featuredDataList;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public List<Banner> getBannerData() {
        return bannerData;
    }

    public void setBannerData(List<Banner> bannerData) {
        this.bannerData = bannerData;
    }

    public String getDigitalEventsDecription() {
        return digitalEventsDecription;
    }

    public void setDigitalEventsDecription(String digitalEventsDecription) {
        this.digitalEventsDecription = digitalEventsDecription;
    }

    public Map<String, DisplayDetails> getDynamicText() {
        return dynamicText;
    }

    public void setDynamicText(Map<String, DisplayDetails> dynamicText) {
        this.dynamicText = dynamicText;
    }

    public List<DigitalEventGroupObject> getDigitalEventGroupObjectList() {
        return digitalEventGroupObjectList;
    }

    public void setDigitalEventGroupObjectList(List<DigitalEventGroupObject> digitalEventGroupObjectList) {
        this.digitalEventGroupObjectList = digitalEventGroupObjectList;
    }
}
