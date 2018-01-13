package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event;

import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetPromotionVO;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class LoadPromotionEvent {
    private List<GetPromotionVO> promotions;
    public LoadPromotionEvent(List<GetPromotionVO>promotions)
    {
        this.promotions=promotions;
    }

    public List<GetPromotionVO> getPromotions() {
        return promotions;
    }
}
