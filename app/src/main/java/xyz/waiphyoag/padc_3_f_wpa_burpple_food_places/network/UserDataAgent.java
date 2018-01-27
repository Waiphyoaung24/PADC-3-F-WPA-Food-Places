package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public interface UserDataAgent {

    void loginUser(String phoneNo,String password);
    void loginRegister(String phoneNo,String password, String name);
}
