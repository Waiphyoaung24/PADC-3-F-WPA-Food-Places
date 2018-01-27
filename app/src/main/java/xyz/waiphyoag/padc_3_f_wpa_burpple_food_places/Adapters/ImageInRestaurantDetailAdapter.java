package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetFeaturedVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetGuidedVO;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewitems.ImageViewItem;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.R;

/**
 * Created by WaiPhyoAg on 1/5/18.
 */

public class ImageInRestaurantDetailAdapter extends PagerAdapter {
    private List<GetFeaturedVO>mImages;
    public ImageInRestaurantDetailAdapter()
    {
        this.mImages=new ArrayList<>();
    }
    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Context context=container.getContext();
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        ImageViewItem view=(ImageViewItem)layoutInflater.inflate(R.layout.item_restaurant_images,container,false);
        view.setData(mImages.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
    public void setFeatures(List<GetFeaturedVO> features)
    {
        mImages=features;
        notifyDataSetChanged();
    }
}
