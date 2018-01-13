package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class BurpplePromotionShopVO {
    @SerializedName("burpple-shop-id")
    private String burppleshopID;
    @SerializedName("burpple-shop-name")
    private String burppleshopName;
    @SerializedName("burpple-shop-area")
    private String burppleshopArea;

    public String getBurppleshopID() {
        return burppleshopID;
    }

    public String getBurppleshopName() {
        return burppleshopName;
    }

    public String getBurppleshopArea() {
        return burppleshopArea;
    }
}
