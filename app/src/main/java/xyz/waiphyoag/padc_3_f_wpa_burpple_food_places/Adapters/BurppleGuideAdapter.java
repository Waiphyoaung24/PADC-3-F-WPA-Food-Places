package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetGuidedVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders.BurppleGuideViewHolder;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders.PromotionAreaViewHolder;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class BurppleGuideAdapter extends RecyclerView.Adapter<BurppleGuideViewHolder>{
    private List<GetGuidedVO>guideList;

    public BurppleGuideAdapter()
    {
        this.guideList = new ArrayList<>();
    }
    @Override
    public BurppleGuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View burppleguide = layoutInflater.inflate(R.layout.item_burpple_guides,parent,false);
        BurppleGuideViewHolder burppleGuideViewHolder=new BurppleGuideViewHolder(burppleguide);
        return burppleGuideViewHolder;
    }

    @Override
    public void onBindViewHolder(BurppleGuideViewHolder holder, int position) {
        holder.setGuideFood(guideList.get(position));
    }



    @Override
    public int getItemCount() {
        return guideList.size();
    }

    public void setGuideFood(List<GetGuidedVO>guides)
    {
        guideList=guides;
        notifyDataSetChanged();
    }
}
