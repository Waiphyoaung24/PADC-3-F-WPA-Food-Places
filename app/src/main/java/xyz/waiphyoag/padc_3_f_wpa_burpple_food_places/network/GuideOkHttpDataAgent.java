package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.BurppleFoodApp;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadGuideEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadPromotionEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetGuidesResponse;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses.GetPromotionResponse;

/**
 * Created by WaiPhyoAg on 1/13/18.
 */

public class GuideOkHttpDataAgent implements GuidesFoodDataAgent {

    private static GuideOkHttpDataAgent objInstance;
    private GuideOkHttpDataAgent()
    {

    }
    public static GuideOkHttpDataAgent getObjInstance ()
    {
        if (objInstance==null)
        {
            objInstance=new GuideOkHttpDataAgent();
        }
        return objInstance;
    }


    @Override
    public void loadGuidePlace() {
        new LoadNewsTask().execute("http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getGuides.php");
    }

    private static class LoadNewsTask extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... urls) {
            String url= urls[0];
            OkHttpClient okHttpClient= new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(20,TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody= new FormBody.Builder()
                    .add("access_token","b002c7e1a528b7cb460933fc2875e916")
                    .add("page","1")
                    .build();

            Request request= new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString=null;
            try
            {
                Response response= okHttpClient.newCall(request).execute();
                if(response.isSuccessful() && response.body()!=null)
                {
                    responseString=response.body().string();
                }
            }
            catch (Exception e)
            {

                Log.e(BurppleFoodApp.LOG_TAG,e.getMessage());
            }


            return responseString;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            Gson gson= new Gson();
            GetGuidesResponse getGuidesResponse=gson.fromJson(response,GetGuidesResponse.class);

            LoadGuideEvent event=new LoadGuideEvent(getGuidesResponse.getGuides());
            EventBus.getDefault().post(event);


        }
    }



}

