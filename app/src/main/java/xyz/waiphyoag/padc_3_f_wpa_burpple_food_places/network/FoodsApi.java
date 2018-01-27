package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetLoginResponse;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetPromotionResponse;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetRegisterResponse;

/**
 * Created by WaiPhyoAg on 1/13/18.
 */

public interface FoodsApi {

    @FormUrlEncoded
    @POST("getPromotions.php")
    Call<GetPromotionResponse> getPromotionResponseCall(@Field("page") int page,

                                                        @Field("access_token")
                                                        String accessToken);
    @FormUrlEncoded
    @POST("login.php")
    Call<GetLoginResponse>getLogin(@Field("phoneNo")String phoneNo,
                                            @Field("password")String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<GetRegisterResponse>getRegister(@Field("phoneNo")String phoneNo,
                                         @Field("password")String password,
                                         @Field("name")String name);
}
