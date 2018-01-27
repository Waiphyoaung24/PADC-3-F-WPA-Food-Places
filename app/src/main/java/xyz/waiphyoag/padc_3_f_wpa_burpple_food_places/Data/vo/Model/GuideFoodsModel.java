package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.GuideOkHttpDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.GuidesFoodDataAgent;

/**
 * Created by WaiPhyoAg on 1/13/18.
 */

public class GuideFoodsModel  {
    private static GuideFoodsModel sObjInstance;
    private GuidesFoodDataAgent mGuidesFoodDataAgent;


    private GuideFoodsModel()
    {
        mGuidesFoodDataAgent= GuideOkHttpDataAgent.getObjInstance();
    }
    public static GuideFoodsModel getsObjInstance()
    {
        if(sObjInstance==null)
        {
            sObjInstance=new GuideFoodsModel();
        }
        return sObjInstance;
    }
    public void loadGuidePlace()

    {
        mGuidesFoodDataAgent.loadGuidePlace();
    }

}
