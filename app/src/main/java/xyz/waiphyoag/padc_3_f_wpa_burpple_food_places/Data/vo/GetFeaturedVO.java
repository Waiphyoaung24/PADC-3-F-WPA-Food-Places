package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class GetFeaturedVO {
    @SerializedName("burpple-featured-id")
    private String burpplefeaturedID;
    @SerializedName("burpple-featured-image")
    private String burpplefeaturedImage;
    @SerializedName("burpple-featured-title")
    private String burpplefeaturedTitle;
    @SerializedName("burpple-featured-desc")
    private String burpplefeaturedDesc;
    @SerializedName("burpple-featured-tag")
    private String burpplefeaturedTag;

    public String getBurpplefeaturedID() {
        return burpplefeaturedID;
    }

    public String getBurpplefeaturedImage() {
        return burpplefeaturedImage;
    }

    public String getBurpplefeaturedTitle() {
        return burpplefeaturedTitle;
    }

    public String getBurpplefeaturedDesc() {
        return burpplefeaturedDesc;
    }

    public String getBurpplefeaturedTag() {
        return burpplefeaturedTag;
    }
}
