package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.BurppleGuideAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.ImageInRestaurantDetailAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.InformationAreaItemAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Adapters.PromotionAreaAdapter;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.FeaturedFoodsModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.GuideFoodsModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.LoginUserModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.Model.PromotionFoodsModel;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Delegates.BeforeLoginDelegate;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Delegates.LoginUserDelegate;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadFeaturedEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadGuideEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Event.LoadPromotionEvent;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.activities.AccountControlActivity;
import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.viewpods.AccountControlViewPod;

public class MainActivity extends AppCompatActivity implements BeforeLoginDelegate,LoginUserDelegate {
    @BindView(R.id.vp_restaurant_images)
    ViewPager vpImages;
    @BindView(R.id.rv_promotion_areas)
    RecyclerView rvAreas;
    @BindView(R.id.rv_guided_areas)
    RecyclerView rvGuidedAreas;
    @BindView(R.id.rv_information_items)
    RecyclerView rvInformationItem;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private AccountControlViewPod vpAccountControl;



    private ImageInRestaurantDetailAdapter imageInRestaurantDetailAdapter;

    private PromotionAreaAdapter promotionAreaAdapter;
    private BurppleGuideAdapter burppleGuideAdapter;
    private InformationAreaItemAdapter informationAreaItemAdapter;

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



        informationAreaItemAdapter = new InformationAreaItemAdapter();
        LinearLayoutManager linearLayoutManagerforInformationItem=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        rvInformationItem.setAdapter(informationAreaItemAdapter);
        rvInformationItem.setLayoutManager(linearLayoutManagerforInformationItem);

        PromotionFoodsModel.getsObjinstance().loadfoods();
        GuideFoodsModel.getsObjInstance().loadGuidePlace();
        FeaturedFoodsModel.getsObjInstance().loadFeautredFood();
        vpAccountControl = (AccountControlViewPod) navigationView.getHeaderView(0);
        vpAccountControl.setmDelegates(this);
        vpAccountControl.setDelegates(this);

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionLoad(LoadPromotionEvent event)
    {
        Log.d(BurppleFoodApp.LOG_TAG,"onPromotionPlacesLoad"+event.getPromotions().size());
        promotionAreaAdapter.setFoods(event.getPromotions());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGuideLoad(LoadGuideEvent event)
    {
        Log.d(BurppleFoodApp.LOG_TAG,"onGuidePlacesLoaded"+event.getGuide().size());
        burppleGuideAdapter.setGuideFood(event.getGuide());
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFeaturesLoad(LoadFeaturedEvent event)
    {
        Log.d(BurppleFoodApp.LOG_TAG,"onFeatuersPlacesLoaded"+event.getFeatured().size());
        imageInRestaurantDetailAdapter.setFeatures(event.getFeatured());
    }

    @OnClick(R.id.iv_menu_bar)
    public void onTapMenu(View view)
    {
     drawerLayout.openDrawer(GravityCompat.START);
    }


    @Override
    public void onTapLogout() {
        LoginUserModel.getsObjInstance().logout();

    }

    @Override
    public void onTapLogin() {
        Intent intent= AccountControlActivity.newIntentLogin(getApplicationContext());
        startActivity(intent);

    }

    @Override
    public void onTapRegister() {
        Intent intent=AccountControlActivity.newIntentRegister(getApplicationContext());
        startActivity(intent);

    }
}
