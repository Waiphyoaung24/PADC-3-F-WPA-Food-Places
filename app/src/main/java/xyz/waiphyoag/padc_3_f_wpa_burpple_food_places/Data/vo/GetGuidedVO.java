package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class GetGuidedVO {
    @SerializedName("burpple-guide-id")
    private String burppleguideID;
    @SerializedName("burpple-guide-image")
    private String burppleguideImage;
    @SerializedName("burpple-guide-title")
    private String burppleguideTitle;
    @SerializedName("burpple-guide-desc")
    private  String burppleguideDesc;

    public String getBurppleguideID() {
        return burppleguideID;
    }

    public String getBurppleguideImage() {
        return burppleguideImage;
    }

    public String getBurppleguideTitle() {
        return burppleguideTitle;
    }

    public String getBurppleguideDesc() {
        return burppleguideDesc;
    }
}


