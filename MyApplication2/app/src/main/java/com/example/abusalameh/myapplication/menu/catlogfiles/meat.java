package com.example.abusalameh.myapplication.menu.catlogfiles;

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
import com.example.abusalameh.myapplication.adapters.RecyclerViewAdapter;
import com.example.abusalameh.myapplication.models.meatandfish;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class meat extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static ArrayList<MeatPart> meatParts = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat);


        Intent intent = getIntent();
        if(meatParts == null) {
            Log.d("test", "no!");
        }
        else {
            Log.d("test", "yes! : " + meatParts.get(0).name);

        }
        recyclerView=findViewById(R.id.rv);
        setuprecyclerview(meatParts);
    }

    //Using Recycle View to show data


    private void setuprecyclerview(ArrayList<MeatPart> meatParts) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,meatParts);
        recyclerView.setAdapter(myadapter);
    }
}
