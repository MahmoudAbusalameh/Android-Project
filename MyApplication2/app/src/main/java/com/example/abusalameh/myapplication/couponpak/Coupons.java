package com.example.abusalameh.myapplication.couponpak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.abusalameh.myapplication.ConnectionAsyncTask;
import com.example.abusalameh.myapplication.R;
import com.example.abusalameh.myapplication.adapters.CouponAdapter;
import com.example.abusalameh.myapplication.models.Coupon;

import java.util.List;

public class Coupons extends AppCompatActivity {
    public static List<Coupon> coupons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);


        ConnectionAsyncTask t = new ConnectionAsyncTask(this) {
            @Override
            protected void onPostExecute(String s) {

                //Using listview
                coupons = CouponJSONParser.getObjectFromJason(s);
                CouponAdapter c = new CouponAdapter(Coupons.this, coupons);
                ListView listview = findViewById(R.id.itemsview);
                listview.setAdapter(c);
            }
        };
        //executing get reguest on api
        t.execute("https://demo2126335.mockable.io/coupons");
    }
}
