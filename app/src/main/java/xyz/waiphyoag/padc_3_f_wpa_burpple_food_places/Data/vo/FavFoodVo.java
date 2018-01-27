package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class FavFoodVo {

    @SerializedName("favorite_food_id")
    private int id;
    private String title;
    private String photoUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
