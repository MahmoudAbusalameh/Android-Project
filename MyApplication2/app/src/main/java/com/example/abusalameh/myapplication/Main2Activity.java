package com.example.abusalameh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

import com.example.abusalameh.myapplication.bestofferpak.BestOffer;
import com.example.abusalameh.myapplication.couponpak.Coupons;
import com.example.abusalameh.myapplication.menu.AboutUs;
import com.example.abusalameh.myapplication.menu.Brands;
import com.example.abusalameh.myapplication.menu.Catalog;
import com.example.abusalameh.myapplication.menu.Contacts;
import com.example.abusalameh.myapplication.menu.NEWaRRIVALS;
import com.example.abusalameh.myapplication.menu.Sale;
/*
        Mani Menu
 */

public class Main2Activity extends AppCompatActivity {
    GridLayout mainGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Created Using Grid Layout

        mainGrid=(GridLayout)findViewById(R.id.mainGrid);

        //Set  Event
        setSingleEvent(mainGrid);

    }

    public void setSingleEvent(GridLayout mainGrid) {

        //Loop all childs

        for (int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView =(CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if(finalI ==0)//open Catalog
                   {
                       Intent intent= new Intent(Main2Activity.this,Catalog.class);
                       startActivity(intent);
                   }
                   else if(finalI ==1)//open sale
                   {
                       Intent intent= new Intent(Main2Activity.this,Sale.class);
                       startActivity(intent);
                   }else if(finalI ==2)//open Cupones
                   {
                       Intent intent= new Intent(Main2Activity.this,Coupons.class);
                       startActivity(intent);
                   }else if(finalI ==3)//open Brands
                   {
                       Intent intent= new Intent(Main2Activity.this,Brands.class);
                       startActivity(intent);
                   }else if(finalI ==4)//open New Arrivals
                   {
                       Intent intent= new Intent(Main2Activity.this,NEWaRRIVALS.class);
                       startActivity(intent);
                   }else if(finalI ==5)//open Best Offers
                   {
                       Intent intent= new Intent(Main2Activity.this,BestOffer.class);
                       startActivity(intent);
                   }else if(finalI ==6)//open About us
                   {
                       Intent intent= new Intent(Main2Activity.this,AboutUs.class);
                       startActivity(intent);
                   }else if(finalI ==7)//open Contacts
                   {
                       Intent intent= new Intent(Main2Activity.this,Contacts.class);
                       startActivity(intent);
                   }
                }
            });
        }
    }
}
