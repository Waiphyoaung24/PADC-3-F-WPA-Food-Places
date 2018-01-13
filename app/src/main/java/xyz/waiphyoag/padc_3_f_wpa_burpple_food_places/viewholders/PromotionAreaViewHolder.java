package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetPromotionVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class PromotionAreaViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_promotion_title)
    TextView tvburpplePromotionTitle;
    @BindView(R.id.tv_promotion_until)
    TextView tvpromotionUntil;
    @BindView(R.id.iv_promoted_food)
    ImageView ivpromotionPic;
    @BindView(R.id.tv_promotion_restaurant_name)
    TextView tvpromotionName;
    @BindView(R.id.tv_restaurant_promotion_address)
    TextView tvpromotionAddress;

    public PromotionAreaViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);



    }


    public void setFoods(GetPromotionVO promotions) {
        tvburpplePromotionTitle.setText(promotions.getBurpplepromotionTitle());
        tvpromotionUntil.setText(promotions.getBurpplepromotionUntil());
        tvpromotionName.setText(promotions.getBurpplePromotionShop().getBurppleshopName());
        tvpromotionAddress.setText(promotions.getBurpplePromotionShop().getBurppleshopArea());

        Glide.with(ivpromotionPic.getContext())
                .load(promotions.getBurpplepromotionImage())
                .into(ivpromotionPic);



        }


    }

