package com.example.abusalameh.myapplication.menu.catlogfiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.abusalameh.myapplication.R;
import com.example.abusalameh.myapplication.adapters.RecyclerViewAdapterF;
import com.example.abusalameh.myapplication.models.foodItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import com.example.abusalameh.myapplication.R;

public class food extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static ArrayList<FoodPart> foodParts = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Intent intent = getIntent();
        if(foodParts == null) {
            Log.d("test", "no!");
        }
        else {
            Log.d("test", "yes! : " + foodParts.get(0).name);

        }
        recyclerView=findViewById(R.id.rv);
        setuprecyclerview(foodParts);
    }


    //Using Recycle View to show data
    private void setuprecyclerview(ArrayList<FoodPart> foodParts) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterF myadapter = new RecyclerViewAdapterF(this,foodParts);
        recyclerView.setAdapter(myadapter);
    }

}
