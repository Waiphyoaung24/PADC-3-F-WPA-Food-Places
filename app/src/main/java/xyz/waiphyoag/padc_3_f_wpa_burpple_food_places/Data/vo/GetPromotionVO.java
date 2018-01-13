package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class GetPromotionVO {
    @SerializedName("burpple-promotion-id")
    private String burpplepromotionID;
    @SerializedName("burpple-promotion-image")
    private String burpplepromotionImage;
    @SerializedName("burpple-promotion-title")
    private String burpplepromotionTitle;
    @SerializedName("burpple-promotion-until")
    private String burpplepromotionUntil;
    @SerializedName("is-burpple-exclusive")
    private Boolean isburppleExclusive;
    @SerializedName("burpple-promotion-terms")
    private List<String> burpplepromotionTerm;
    @SerializedName("burpple-promotion-shop")
    private BurpplePromotionShopVO burpplePromotionShop;

    public String getBurpplepromotionID() {
        return burpplepromotionID;
    }

    public String getBurpplepromotionImage() {
        return burpplepromotionImage;
    }

    public String getBurpplepromotionTitle() {
        return burpplepromotionTitle;
    }

    public String getBurpplepromotionUntil() {
        return burpplepromotionUntil;
    }

    public BurpplePromotionShopVO getBurpplePromotionShop() {
        return burpplePromotionShop;
    }

    public Boolean getIsburppleExclusive() {
        return isburppleExclusive;
    }

    public List<String> getBurpplepromotionTerm() {
        return burpplepromotionTerm;
    }


}
