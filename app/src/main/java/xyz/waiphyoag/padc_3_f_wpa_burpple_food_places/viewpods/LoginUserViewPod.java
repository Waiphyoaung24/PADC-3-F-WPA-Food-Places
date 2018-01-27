package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.LoginVo;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Delegates.LoginUserDelegate;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class LoginUserViewPod extends RelativeLayout {
    @BindView(R.id.iv_main_profile)
    ImageView ivMain;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone_number)
    TextView tvPhoneNo;
    @BindView(R.id.iv_cover)
    ImageView ivCover;

    private LoginUserDelegate mLoginUserDelegate;

    public void setloginDelegates(LoginUserDelegate mloginDelegates) {
        this.mLoginUserDelegate = mloginDelegates;
    }

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);

    }

    public void bindData(LoginVo loginVO) {
        Glide.with(ivMain.getContext())
                .load(loginVO.getProfileUrl())
                .into(ivMain);

        tvName.setText(loginVO.getName());
        tvPhoneNo.setText(loginVO.getPhoneNo());

        Glide.with(ivCover.getContext())
                .load(loginVO.getCoverUrl())
                .into(ivCover);


    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(View view) {
        mLoginUserDelegate.onTapLogout();
    }
}

