package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.RegisterVO;

/**
 * Created by WaiPhyoAg on 1/27/18.
 */

public class RegisterSuccessEvent {
    private RegisterVO registerVO;

    public RegisterSuccessEvent(RegisterVO registerVO) {
        this.registerVO = registerVO;
    }

    public RegisterVO getRegisterVO() {
        return registerVO;
    }
}
