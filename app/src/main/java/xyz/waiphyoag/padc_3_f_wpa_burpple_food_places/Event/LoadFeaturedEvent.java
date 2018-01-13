package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event;

import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetFeaturedVO;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class LoadFeaturedEvent {
    private List<GetFeaturedVO>featured;

    public List<GetFeaturedVO> getFeatured() {
        return featured;
    }

    public LoadFeaturedEvent(List<GetFeaturedVO>featured)
    {
        this.featured=featured;

    }
}
