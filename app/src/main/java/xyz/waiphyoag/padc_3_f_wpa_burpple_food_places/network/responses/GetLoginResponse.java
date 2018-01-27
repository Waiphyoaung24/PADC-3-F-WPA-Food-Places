package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses;

import com.google.gson.annotations.SerializedName;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.LoginVo;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class GetLoginResponse {
    private int code;
    private String message;
    @SerializedName("login_user")
    private LoginVo loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginVo getLoginUser() {
        return loginUser;
    }

}
