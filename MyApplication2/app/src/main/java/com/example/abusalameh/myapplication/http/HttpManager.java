package com.example.abusalameh.myapplication.http;


import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 /          Http Manager used in Coupons and best offers
  */
public class HttpManager {

    public static String getData(String URI) {
        BufferedReader bufferedReader = null;
        try {

            URL url = new URL(URI);
            // Opening Connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            // Reading to buffer
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line +'\n');
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } catch (Exception ex) {
            Log.d("HttpURLConnection",ex.toString());
        }
        return null;


    }
}
