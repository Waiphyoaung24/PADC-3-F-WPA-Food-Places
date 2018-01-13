package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetPromotionResponse;

/**
 * Created by WaiPhyoAg on 1/13/18.
 */

public interface FoodsApi {

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionResponse> getPromotionResponseCall(@Field("page") int page,

                                                        @Field("access_token")
                                                        String accessToken);
}
