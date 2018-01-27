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

import retrofit2.converter.gson.GsonConverterFactory;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadPromotionEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoginSuccessEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.RegisterSuccessEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetLoginResponse;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetPromotionResponse;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetRegisterResponse;


/**
 * Created by WaiPhyoAg on 1/6/18.
 */

public class RetrofitDataAgent implements UserDataAgent {
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
    public void loginUser(String phoneNo, String password) {
        final Call<GetLoginResponse>getLoginResponseCall= mFoodsApi.getLogin(phoneNo,password);
        getLoginResponseCall.enqueue(new Callback<GetLoginResponse>() {
            @Override
            public void onResponse(Call<GetLoginResponse> call, Response<GetLoginResponse> response) {
                GetLoginResponse getLoginResponseCall1=response.body();
                if(getLoginResponseCall1!=null)
                {
                    LoginSuccessEvent event= new LoginSuccessEvent(getLoginResponseCall1.getLoginUser());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetLoginResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void loginRegister(String phoneNo, String password, String name) {

        Call<GetRegisterResponse> getRegisterResponseCall = mFoodsApi.getRegister(phoneNo, password, name);
        getRegisterResponseCall.enqueue(new Callback<GetRegisterResponse>() {
            @Override
            public void onResponse(Call<GetRegisterResponse> call, Response<GetRegisterResponse> response) {
                GetRegisterResponse getRegisterResponse = response.body();
                if (getRegisterResponse != null) {
                    RegisterSuccessEvent event = new RegisterSuccessEvent(getRegisterResponse.getRegisterUser());
                    EventBus.getDefault().post(event);
                }

            }

            @Override
            public void onFailure(Call<GetRegisterResponse> call, Throwable t) {

            }
        });


    }
}


