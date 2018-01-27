package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model;

import org.greenrobot.eventbus.EventBus;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.RegisterVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.RegisterSuccessEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.RetrofitDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.UserDataAgent;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class RegisterModel {
    private static RegisterModel sObjInstance;
    private UserDataAgent mDataAgent;
    private RegisterVO registerVO;

    private RegisterModel()
    {
        mDataAgent= RetrofitDataAgent.getsObjInstance();
        EventBus.getDefault().register(this);
    }
    public static RegisterModel getsObjInstance()
    {
        if(sObjInstance==null)
        {
            sObjInstance=new RegisterModel();
        }
        return sObjInstance;
    }
    public void loginRegister(String phoneNo,String password,String name)
    {
        mDataAgent.loginRegister(phoneNo, password, name);
    }
    public void onRegisterSuccess (RegisterSuccessEvent event)
    {
        registerVO=event.getRegisterVO();
    }
}
