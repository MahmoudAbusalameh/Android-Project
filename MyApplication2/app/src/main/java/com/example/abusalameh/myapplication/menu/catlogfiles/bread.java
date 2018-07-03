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
import com.example.abusalameh.myapplication.adapters.RecyclerViewAdapterB;
import com.example.abusalameh.myapplication.models.breadmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class bread extends AppCompatActivity {

    private RecyclerView recyclerView;
    public static ArrayList<BreadPart> breadParts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);
        Intent intent = getIntent();
        if(breadParts == null) {
            Log.d("test", "no!");
        }
        else {
            Log.d("test", "yes! : " + breadParts.get(0).name);

        }
        recyclerView=findViewById(R.id.rv);
        setuprecyclerview(breadParts);
    }

    //Using Recycle View to show data

    private void setuprecyclerview(ArrayList<BreadPart> breadParts) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterB myadapter = new RecyclerViewAdapterB(this,breadParts);
        recyclerView.setAdapter(myadapter);
    }

}
