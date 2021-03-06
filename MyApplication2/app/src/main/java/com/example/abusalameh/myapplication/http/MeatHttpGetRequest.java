package com.example.abusalameh.myapplication.http;

import android.os.AsyncTask;
import android.util.Log;

import com.example.abusalameh.myapplication.menu.Catalog;
import com.example.abusalameh.myapplication.menu.catlogfiles.MeatPart;
import com.example.abusalameh.myapplication.menu.catlogfiles.meat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MeatHttpGetRequest extends AsyncTask<String, Void, String> {

    Catalog catalog = null;
    ArrayList<MeatPart> meatParts = new ArrayList<>();
    public MeatHttpGetRequest (Catalog catalog) {
        this.catalog = catalog;
    }


    @Override
    protected String doInBackground(String... params){

        String result;
        String inputLine;
        try {
            //Create a URL object holding our url
            Log.d("test", "k0");
            URL myUrl = new URL("http://demo2126335.mockable.io/getmeatproducts");

            //Create a connection
            HttpURLConnection connection =(HttpURLConnection)
                    myUrl.openConnection();
            Log.d("test", "k1");


            //Connect to our url
            connection.connect();
            Log.d("test", "k2");

            //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            //Check if the line we are reading is not null
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }

            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();
            //Set our result equal to our stringBuilder
            result = stringBuilder.toString();
            Log.d("test", result);
        }
        catch(IOException e){
            e.printStackTrace();
            result = null;
        }
        return result;
    }
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {
            JSONObject jsonObject = new JSONObject(result);
            Log.d("test", "first object");
            JSONArray foodlist = jsonObject.getJSONArray("foodlist");
            Log.d("test", "first array");
            Log.d("test", foodlist.length()+"");
            for(int i = 0; i < foodlist.length() ; i++) {
                JSONObject foodItem = foodlist.getJSONObject(i);
                Log.d("test", i+" object in array");
                MeatPart meatPart = new MeatPart();

                String name = foodItem.getString("name");
                Log.d("test", "name");
                String price = foodItem.getString("price");
                Log.d("test", "first price");
                Log.d("test", "name : "+name + "price : "+ price);

                meatPart.name = name;
                meatPart.price = price;

                meatParts.add(meatPart);
            }
            Log.d("test", "size = "+meatParts.size());
        } catch (JSONException e) {
            Log.d("test", "exeption");
        }

        meat.meatParts = meatParts;
        catalog.start2();
    }
}
