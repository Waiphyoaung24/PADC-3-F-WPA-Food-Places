package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.PromotionFoodsDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.PromotionOkHttpDataAgentPromotion;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class PromotionFoodsModel {

    private static PromotionFoodsModel sObjinstance;
    private PromotionFoodsDataAgent mPromotionFoodsDataAgent;

    private PromotionFoodsModel()
    {
//        mPromotionFoodsDataAgent= RetrofitDataAgentPromotion.getsObjInstance();
         mPromotionFoodsDataAgent = PromotionOkHttpDataAgentPromotion.getObjInstance();
    }
    public static PromotionFoodsModel getsObjinstance ()
    {
        if(sObjinstance==null)
        {
            sObjinstance=new PromotionFoodsModel();
        }
        return sObjinstance;
    }
    public void loadfoods()
    {
        mPromotionFoodsDataAgent.loadfoods();
    }
}
