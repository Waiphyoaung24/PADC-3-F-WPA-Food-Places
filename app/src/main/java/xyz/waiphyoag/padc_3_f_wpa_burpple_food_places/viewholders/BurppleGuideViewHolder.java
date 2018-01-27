package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetGuidedVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class BurppleGuideViewHolder extends RecyclerView.ViewHolder {
         @BindView(R.id.tv_guide_title)
    TextView burppleguideTitle;
         @BindView(R.id.iv_guide_image)
    ImageView burppleguideImage;

    public BurppleGuideViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void setGuideFood(GetGuidedVO guides)
    {
        burppleguideTitle.setText(guides.getBurppleguideTitle());
        Glide.with(burppleguideImage.getContext())
                .load(guides.getBurppleguideImage())
                .into(burppleguideImage);
    }

}
