package com.example.abusalameh.myapplication.bestofferpak;



import com.example.abusalameh.myapplication.models.Offer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// JSON for offers

public class OffersJSONParser {

    public static List<Offer> getObjectFromJason(String jason)
    {
        List<Offer> offers;
        try {

            JSONObject jsonObject1 = new JSONObject(jason);
            JSONArray jsonArray = jsonObject1.getJSONArray("offerlist");
            offers = new ArrayList<>();
            for(int i=0;i<jsonArray.length();i++)
            {

                //Creating json object
                JSONObject jsonObject = new JSONObject();
                jsonObject= (JSONObject) jsonArray.get(i);
                Offer offer = new Offer();
                ArrayList<String> a = new ArrayList<>();
                JSONArray itemlist = jsonObject.getJSONArray("itemlist");
                for (int j = 0; j < itemlist.length(); j++){
                    a.add(itemlist.get(j).toString());
                }

                offer.setItemlist(a);
                offer.setPrice(jsonObject.getInt("price"));
                offers.add(offer);
            }

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return offers;
    }
}