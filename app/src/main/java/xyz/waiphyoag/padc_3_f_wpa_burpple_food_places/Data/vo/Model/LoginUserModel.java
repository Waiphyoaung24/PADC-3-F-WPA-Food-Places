package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.LoginVo;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoginSuccessEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.UserLogoutEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.RetrofitDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.UserDataAgent;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class LoginUserModel {
    private static LoginUserModel sObjInstance;
    private UserDataAgent mDataAgent;
    private LoginVo mLoginUser;

    private LoginUserModel() {
        mDataAgent = RetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new LoginUserModel();
        }
        return sObjInstance;
    }

    public void loginUser(String phoneNo, String password) {
        mDataAgent.loginUser(phoneNo, password);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginSuccess(LoginSuccessEvent event) {
        mLoginUser = event.getLoginVo();
    }

    public boolean isUserLogin() {
        return mLoginUser != null;
    }

    public void logout() {
        mLoginUser = null;
        UserLogoutEvent event = new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }

}
