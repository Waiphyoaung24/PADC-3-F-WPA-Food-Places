package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network;

/**
 * Created by WaiPhyoAg on 1/13/18.
 */

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadPromotionEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetPromotionResponse;


/**
 * Created by WaiPhyoAg on 1/6/18.
 */

public class RetrofitDataAgent implements FoodsDataAgent {
    private static RetrofitDataAgent sObjInstance;
    private FoodsApi mFoodsApi;

    private RetrofitDataAgent() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        mFoodsApi = retrofit.create(FoodsApi.class);

    }

    public static RetrofitDataAgent getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new RetrofitDataAgent();
        }
        return sObjInstance;
    }
    @Override
    public void loadfoods() {
        Call<GetPromotionResponse> getPromotionResponseCall = mFoodsApi.getPromotionResponseCall(1, "b002c7e1a528b7cb460933fc2875e916");
        getPromotionResponseCall.enqueue(new Callback<GetPromotionResponse>() {
            @Override
            public void onResponse(Call<GetPromotionResponse> call, Response<GetPromotionResponse> response) {
                GetPromotionResponse getPromotionResponse = response.body();
                if (getPromotionResponse != null) {
                    LoadPromotionEvent event = new LoadPromotionEvent(getPromotionResponse.getPromotions());
                    EventBus.getDefault().post(event);
                }


            }

            @Override
            public void onFailure(Call<GetPromotionResponse> call, Throwable t) {

            }
        });




            }

    }

