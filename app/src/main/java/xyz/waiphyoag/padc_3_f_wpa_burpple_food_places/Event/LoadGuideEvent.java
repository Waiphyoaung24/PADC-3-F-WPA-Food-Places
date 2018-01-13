package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event;

import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetGuidedVO;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class LoadGuideEvent {
    private List<GetGuidedVO>guide;
    public LoadGuideEvent(List<GetGuidedVO>guide)
    {
        this.guide=guide;
    }


    public List<GetGuidedVO> getGuide() {
        return guide;
    }
}
