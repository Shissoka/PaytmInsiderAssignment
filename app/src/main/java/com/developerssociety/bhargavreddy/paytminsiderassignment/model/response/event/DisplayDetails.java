package com.developerssociety.bhargavreddy.paytminsiderassignment.model.response.event;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisplayDetails {

    @SerializedName("seo_title")
    @Expose
    private String seoTitle;
    @SerializedName("seo_description")
    @Expose
    private String seoDescription;

    @SerializedName("link_type")
    @Expose
    private String linkType;

    @SerializedName("link_slug")
    @Expose
    private String linkSlug;



    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkSlug() {
        return linkSlug;
    }

    public void setLinkSlug(String linkSlug) {
        this.linkSlug = linkSlug;
    }
}