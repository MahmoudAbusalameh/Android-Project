package com.example.abusalameh.myapplication.couponpak;


import com.example.abusalameh.myapplication.models.Coupon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
//JSON Parser

public class CouponJSONParser {


    public static List<Coupon> getObjectFromJason(String jason)
    {

        List<Coupon> coupons;
        try {

            JSONArray jsonArray = new JSONArray(jason);
            coupons = new ArrayList<>();
            for(int i=0;i<jsonArray.length();i++)
            {
                //Creating json object
                JSONObject jsonObject = new JSONObject();
                jsonObject= (JSONObject) jsonArray.get(i);
                Coupon coupon = new Coupon();
                coupon.setName(jsonObject.getString("name"));
                coupon.setDescription(jsonObject.getString("des"));
                coupons.add(coupon);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


        return coupons;
    }
}