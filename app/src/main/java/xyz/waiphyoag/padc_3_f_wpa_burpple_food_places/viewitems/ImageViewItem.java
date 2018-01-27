package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetFeaturedVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class ImageViewItem extends FrameLayout {
    @BindView(R.id.iv_restaurant_images)
    ImageView featuredImage;
    @BindView(R.id.tv_restaurant_title)
    TextView tvrestaurantTitle;
    @BindView(R.id.tv_featured_tag)
    TextView tvfeaturedTag;
    @BindView(R.id.tv_feature_desc)
    TextView tvFeatureDesc;

    public ImageViewItem(@NonNull Context context) {
        super(context);
    }

    public ImageViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void setData (GetFeaturedVO features)
    {
        Glide.with(featuredImage.getContext())
                .load(features.getBurpplefeaturedImage())
                .into(featuredImage);
        tvrestaurantTitle.setText(features.getBurpplefeaturedTitle());
        tvfeaturedTag.setText(features.getBurpplefeaturedTag());
        tvFeatureDesc.setText(features.getBurpplefeaturedDesc());


    }

}
