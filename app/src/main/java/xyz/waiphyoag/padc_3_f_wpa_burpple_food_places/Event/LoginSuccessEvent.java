package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.LoginVo;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class LoginSuccessEvent {
    private LoginVo loginVo;

    public LoginSuccessEvent(LoginVo loginVo) {
        this.loginVo = loginVo;
    }

    public LoginVo getLoginVo() {
        return loginVo;
    }
}
