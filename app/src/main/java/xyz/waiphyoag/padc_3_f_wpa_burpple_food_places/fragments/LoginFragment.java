package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.LoginUserModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoginSuccessEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class LoginFragment extends Fragment {
    @BindView(R.id.et_email_mobile)
    EditText etemail;
    @BindView(R.id.et_password)
    EditText etpassword;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_login,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @OnClick(R.id.btn_login)
    public void onTapLogin(View view)
    {
        String phoneNo=etemail.getText().toString();
        String password=etpassword.getText().toString();
        LoginUserModel.getsObjInstance().loginUser(phoneNo,password);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginUserSuccess(LoginSuccessEvent event)
    {
        if(getActivity()!=null) {
            getActivity().onBackPressed();
        }


    }


}
