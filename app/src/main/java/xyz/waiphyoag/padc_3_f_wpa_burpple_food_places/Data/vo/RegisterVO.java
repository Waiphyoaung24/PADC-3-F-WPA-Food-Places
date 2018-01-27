package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo;

/**
 * Created by WaiPhyoAg on 1/27/18.
 */

public class RegisterVO {
    private int userID;
    private String name;
    private String email;
    private String phoneNo;
    private String profileUrl;
    private String coverUrl;

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }
}
