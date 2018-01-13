package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.BurppleGuideAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.ImageInRestaurantDetailAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.InformationAreaAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.PromotionAreaAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.FoodsModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadPromotionEvent;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.vp_restaurant_images)
    ViewPager vpImages;
    @BindView(R.id.rv_promotion_areas)
    RecyclerView rvAreas;
    @BindView(R.id.rv_guided_areas)
    RecyclerView rvGuidedAreas;
    @BindView(R.id.rv_information_areas)
    RecyclerView rvInformationAreas;


    private ImageInRestaurantDetailAdapter imageInRestaurantDetailAdapter;

    private PromotionAreaAdapter promotionAreaAdapter;
    private BurppleGuideAdapter burppleGuideAdapter;
    private InformationAreaAdapter informationAreaAdapter;

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);

        imageInRestaurantDetailAdapter=new ImageInRestaurantDetailAdapter();
        vpImages.setAdapter(imageInRestaurantDetailAdapter);

        promotionAreaAdapter=new PromotionAreaAdapter ();
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvAreas.setAdapter(promotionAreaAdapter);
        rvAreas.setLayoutManager(linearLayoutManager);

        burppleGuideAdapter = new BurppleGuideAdapter();
        LinearLayoutManager linearLayoutManagerforguidedArea = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvGuidedAreas.setLayoutManager(linearLayoutManagerforguidedArea);
        rvGuidedAreas.setAdapter(burppleGuideAdapter);

        informationAreaAdapter= new InformationAreaAdapter();
        LinearLayoutManager linearLayoutManagerforInformation=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvInformationAreas.setAdapter(informationAreaAdapter);
        rvInformationAreas.setLayoutManager(linearLayoutManagerforInformation);

        FoodsModel.getsObjinstance().loadfoods();


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoad(LoadPromotionEvent event)
    {
        Log.d(BurppleFoodApp.LOG_TAG,"onPromotionPlacesLoad"+event.getPromotions().size());
        promotionAreaAdapter.setFoods(event.getPromotions());
    }
}
