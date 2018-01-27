package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewpods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.LoginUserModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Delegates.BeforeLoginDelegate;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Delegates.LoginUserDelegate;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoginSuccessEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.UserLogoutEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.view_pod_before_login)
    BeforeLoginUserViewPod vpBeforeLogin;
    @BindView(R.id.view_pod_login_user)
    LoginUserViewPod vpLoginUser;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);

        refreshUserSession();

        EventBus.getDefault().register(this);

    }

    public void setmDelegates(BeforeLoginDelegate beforeLoginDelegate) {
        vpBeforeLogin.setmDelegate(beforeLoginDelegate);
    }

    public void setDelegates(LoginUserDelegate loginUserDelegates) {
        vpLoginUser.setloginDelegates(loginUserDelegates);
    }

    private void refreshUserSession() {
        if (LoginUserModel.getsObjInstance().isUserLogin())

            vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(LoginSuccessEvent event) {

        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);

        vpLoginUser.bindData(event.getLoginVo());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLogoutUser(UserLogoutEvent event)
    {
        vpLoginUser.setVisibility(View.GONE);
        vpBeforeLogin.setVisibility(View.VISIBLE);
    }
}

