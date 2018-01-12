package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders.PromotionAreaViewHolder;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class BurppleGuideAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View burppleguide = layoutInflater.inflate(R.layout.item_burpple_guides,parent,false);
        PromotionAreaViewHolder promotionAreaViewHolder=new PromotionAreaViewHolder(burppleguide);
        return promotionAreaViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
