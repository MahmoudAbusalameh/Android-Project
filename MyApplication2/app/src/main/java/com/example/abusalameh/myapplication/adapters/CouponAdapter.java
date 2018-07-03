package com.example.abusalameh.myapplication.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.abusalameh.myapplication.R;
import com.example.abusalameh.myapplication.models.Coupon;

import java.util.List;

// Cuopon Adapter
public class CouponAdapter extends ArrayAdapter<Coupon> {

    private final Activity context;
    private final List<Coupon> list;



    public CouponAdapter(Activity context, List<Coupon> list) {
        super(context, R.layout.list_ite, list);
        this.context=context;
        this.list=list;
    }



    public View getView(int position,View view,ViewGroup parent) {

        //inflating the layout with data
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_item_coupons, null,true);


        TextView txtTitle = (TextView) rowView.findViewById(R.id.listItemName_c);
        TextView extratxt = (TextView) rowView.findViewById(R.id.listItemDescription_c);


        txtTitle.setText(list.get(position).getName());
        extratxt.setText(list.get(position).getDescription());
        return rowView;

    };
}