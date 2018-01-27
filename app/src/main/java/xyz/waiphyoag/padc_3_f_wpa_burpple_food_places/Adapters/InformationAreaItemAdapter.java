package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewholders.InformationItemViewHolder;

/**
 * Created by WaiPhyoAg on 1/20/18.
 */

public class InformationAreaItemAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_information_areas_item,parent,false);
        InformationItemViewHolder informationItemViewHolder= new InformationItemViewHolder(view);
        return informationItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
