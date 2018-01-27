package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Delegates.BeforeLoginDelegate;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/26/18.
 */

public class BeforeLoginUserViewPod extends RelativeLayout {
    private BeforeLoginDelegate mDelegate;
    public BeforeLoginUserViewPod(Context context) {
        super(context);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);

    }
    @OnClick(R.id.btn_login)
    public void onTapLogin(View view)
    {
        mDelegate.onTapLogin();

    }

    public void setmDelegate(BeforeLoginDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }
    @OnClick(R.id.btn_to_register)
    public void onTapRegister(View view)
    {
        mDelegate.onTapRegister();

    }

}
