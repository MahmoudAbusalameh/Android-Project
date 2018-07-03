package com.example.abusalameh.myapplication.adapters;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.abusalameh.myapplication.menu.catlogfiles.NonFoodPart;

import com.example.abusalameh.myapplication.R;

import java.util.ArrayList;

//Using Recycle View

public class RecyclerViewAdapterNF extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context mContext;
    private ArrayList <NonFoodPart> mData;
    RequestOptions option;

    public RecyclerViewAdapterNF(Context mContext, ArrayList<NonFoodPart> mData) {
        this.mContext = mContext;
        this.mData = mData;
        option= new RequestOptions().centerCrop().placeholder(R.drawable.laod).error(R.drawable.laod);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        //inflating the layout with data
        LayoutInflater inflater= LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.meatandfish_row_item, parent,false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Log.d("test2", "position = " + position);
        //filling data

        holder.tv_name.setText(mData.get(position).name);
        holder.tv_price.setText(mData.get(position).price);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_price;
        ImageView image_thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name= itemView.findViewById(R.id.item_name);
            tv_price=itemView.findViewById(R.id.item_price);
            image_thumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }

}
