package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetPromotionVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders.PromotionAreaViewHolder;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class PromotionAreaAdapter extends RecyclerView.Adapter <PromotionAreaViewHolder>{
    private List<GetPromotionVO> promotionsList;

    public PromotionAreaAdapter() {
        this.promotionsList = new ArrayList<>();
    }

    @Override
    public PromotionAreaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promotionareaViews = layoutInflater.inflate(R.layout.item_promotion_areas, parent, false);
        PromotionAreaViewHolder promotionAreaViewHolder = new PromotionAreaViewHolder(promotionareaViews);
        return promotionAreaViewHolder;

    }

    @Override
    public void onBindViewHolder(PromotionAreaViewHolder holder, int position) {
        holder.setFoods(promotionsList.get(position));
    }



    @Override
    public int getItemCount() {
        return promotionsList.size();
    }

    public void setFoods(List<GetPromotionVO> promotions) {
            promotionsList=promotions;
            notifyDataSetChanged();
    }
}