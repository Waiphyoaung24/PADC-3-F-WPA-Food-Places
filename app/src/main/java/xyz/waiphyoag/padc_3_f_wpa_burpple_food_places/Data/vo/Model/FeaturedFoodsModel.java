package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.FeaturedFoodDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.FeaturedOkHttpDataAgent;

/**
 * Created by WaiPhyoAg on 1/14/18.
 */

public class FeaturedFoodsModel {
    private static FeaturedFoodsModel sObjInstance;
    private FeaturedFoodDataAgent mFeaturedFoodDataAgent;

    private FeaturedFoodsModel()
    {
     mFeaturedFoodDataAgent= FeaturedOkHttpDataAgent.getObjInstance();
    }
    public static FeaturedFoodsModel getsObjInstance()
    {
        if(sObjInstance==null)
        {
            sObjInstance=new FeaturedFoodsModel();
        }
        return sObjInstance;
    }
    public void loadFeautredFood()
    {
        mFeaturedFoodDataAgent.loadFeaturedFood();
    }
}
