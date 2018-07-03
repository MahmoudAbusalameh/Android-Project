package com.example.abusalameh.myapplication.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.example.abusalameh.myapplication.R;
import com.example.abusalameh.myapplication.http.BreadHttpGetRequest;
import com.example.abusalameh.myapplication.http.FoodHttpGetRequest;
import com.example.abusalameh.myapplication.http.MeatHttpGetRequest;
import com.example.abusalameh.myapplication.http.NonFoodHttpGetRequest;
import com.example.abusalameh.myapplication.menu.catlogfiles.bread;
import com.example.abusalameh.myapplication.menu.catlogfiles.food;
import com.example.abusalameh.myapplication.menu.catlogfiles.meat;
import com.example.abusalameh.myapplication.menu.catlogfiles.nonfood;

/*
Catlog class shows options
 */

public class Catalog extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        //If meat and fish image clicked
        ImageView mf = (ImageView)findViewById(R.id.mf1);
        mf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "kk1");
                MeatHttpGetRequest meatHttpGetRequest = new MeatHttpGetRequest(Catalog.this);
                meatHttpGetRequest.execute();
                Log.d("test", "kk2");
            }
        });

        //If bread image clicked
        ImageView br = (ImageView)findViewById(R.id.b2);
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "kk1");
                BreadHttpGetRequest breadHttpGetRequest = new BreadHttpGetRequest(Catalog.this);
                breadHttpGetRequest.execute();
                Log.d("test", "kk2");
            }
        });

        //If food stuffs image clicked
        ImageView foo = (ImageView)findViewById(R.id.f3);
        foo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "kk1");
                FoodHttpGetRequest foodHttpGetRequest = new FoodHttpGetRequest(Catalog.this);
                foodHttpGetRequest.execute();
                Log.d("test", "kk2");
            }
        });

        //If non food stuffs image clicked
        ImageView noo = (ImageView)findViewById(R.id.f4);
        noo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("test", "kk1");
                NonFoodHttpGetRequest nonFoodHttpGetRequest = new NonFoodHttpGetRequest(Catalog.this);
                nonFoodHttpGetRequest.execute();
                Log.d("test", "kk2");
            }
        });
    }

    public void start1() {
        Intent intent= new Intent(Catalog.this,bread.class);
        startActivity(intent);
    }
    public void start2() {
        Intent intent= new Intent(Catalog.this,meat.class);
        startActivity(intent);
    }
    public void start3() {
        Intent intent= new Intent(Catalog.this,food.class);
        startActivity(intent);
    }
    public void start4() {
        Intent intent= new Intent(Catalog.this,nonfood.class);
        startActivity(intent);
    }
}
