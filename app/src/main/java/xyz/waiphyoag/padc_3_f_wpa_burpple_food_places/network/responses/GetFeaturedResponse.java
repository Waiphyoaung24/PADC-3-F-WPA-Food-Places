package xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.network.responses;

import java.util.List;

import xyz.waiphyoag.padc_3_f_wpa_burpple_food_places.Data.vo.GetFeaturedVO;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class GetFeaturedResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<GetFeaturedVO>featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<GetFeaturedVO> getFeatured() {
        return featured;
    }
}
