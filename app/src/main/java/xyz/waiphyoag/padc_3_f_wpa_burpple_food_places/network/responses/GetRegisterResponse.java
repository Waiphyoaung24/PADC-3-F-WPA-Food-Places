package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses;

import com.google.gson.annotations.SerializedName;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.LoginVo;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.RegisterVO;

/**
 * Created by WaiPhyoAg on 1/27/18.
 */

public class GetRegisterResponse {
    private int code;
    private String message;
    @SerializedName("login_user")
    private RegisterVO registerUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public RegisterVO getRegisterUser() {
        return registerUser;
    }
}
