package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model;

import okhttp3.OkHttpClient;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.FoodsDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.OkHttpDataAgent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.RetrofitDataAgent;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class FoodsModel {

    private static FoodsModel sObjinstance;
    private FoodsDataAgent mFoodsDataAgent;

    private FoodsModel()
    {
//        mFoodsDataAgent= RetrofitDataAgent.getsObjInstance();
        mFoodsDataAgent= OkHttpDataAgent.getObjInstance();
    }
    public static FoodsModel getsObjinstance ()
    {
        if(sObjinstance==null)
        {
            sObjinstance=new FoodsModel();
        }
        return sObjinstance;
    }
    public void loadfoods()
    {
        mFoodsDataAgent.loadfoods();
    }
}
