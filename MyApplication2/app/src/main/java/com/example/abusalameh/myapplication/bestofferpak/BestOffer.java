package com.example.abusalameh.myapplication.bestofferpak;


import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abusalameh.myapplication.ConnectionAsyncTask;
import com.example.abusalameh.myapplication.R;
import com.example.abusalameh.myapplication.models.Offer;

import java.util.List;

public class BestOffer extends AppCompatActivity {

    public static List<Offer> offers;
    public LinearLayout [] hor;
    public LinearLayout [] innerLayout;
    public TextView[] textViews;
    public LinearLayout [] temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LinearLayout objFirstLinearLayout = new LinearLayout(this);
        objFirstLinearLayout.setBackgroundResource(R.drawable.offersbg);
        objFirstLinearLayout.setOrientation(LinearLayout.VERTICAL);


        setContentView(objFirstLinearLayout);




        ConnectionAsyncTask t1 = new ConnectionAsyncTask(this) {


            @Override
            protected void onPostExecute(String s) {
                offers = OffersJSONParser.getObjectFromJason(s);
                hor = new LinearLayout[offers.size()/2];
                innerLayout = new LinearLayout[offers.size()];
                textViews = new TextView[offers.size()];
                temp = new LinearLayout[offers.size()/2];

                for (int i=0;i<offers.size()/2;i++) {
                    hor[i] = new LinearLayout(BestOffer.this);
                    temp[i] = new LinearLayout(BestOffer.this);

                    if (i == 0) {
                        hor[i].setPadding(120, 220, 120, 0);
                        temp[i].setPadding(120, 120, 120, 120);
                        temp[i].setLayoutParams(new ActionBar.LayoutParams(120, 580));
                    }else {
                        temp[i].setPadding(120, 120, 120, 0);
                        hor[i].setPadding(120, 120, 120, 0);
                        temp[i].setLayoutParams(new ActionBar.LayoutParams(120, 500));
                    }
                    if (i == 0)
                        hor[i].setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 580));
                    else {
                        hor[i].setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 580));
                    }

                    innerLayout[i*2 + 0] = new LinearLayout(BestOffer.this);
                    if ( (i*2 + 1) != offers.size())
                        innerLayout[i*2 + 1] = new LinearLayout(BestOffer.this);
                    if (i == 0) {
                        innerLayout[i * 2 + 0].setPadding(20, 20, 20, 20);
                        if ( (i*2 + 1) != offers.size())
                            innerLayout[i * 2 + 1].setPadding(20, 20, 20, 20);
                    }else {
                        innerLayout[i * 2 + 0].setPadding(20, 20, 20, 0);
                        if ( (i*2 + 1) != offers.size())
                            innerLayout[i * 2 + 1].setPadding(20, 20, 20, 0);
                    }

                    textViews[i * 2 + 0] = new TextView(BestOffer.this);
                    textViews[i * 2 + 0].setTextSize(14);
                    textViews[i * 2 + 0].setTypeface(null, Typeface.BOLD);

                    if ( (i*2 + 1) != offers.size()) {
                        textViews[i * 2 + 1] = new TextView(BestOffer.this);
                        textViews[i * 2 + 1].setTextSize(14);
                        textViews[i * 2 + 1].setTypeface(null, Typeface.BOLD);


                    }

                    textViews[i * 2 + 0].setText(offers.get(i * 2 + 0).itemList());
                    if ( (i*2 + 1) != offers.size())
                        textViews[i * 2 + 1].setText(offers.get(i * 2 + 1).itemList());

                    if (i==0) {

                        textViews[i * 2 + 0].setPadding(0, 150, 0, 0);
                        if ( (i*2 + 1) != offers.size())
                            textViews[i * 2 + 1].setPadding(0, 150, 0, 0);
                    }else {
                        textViews[i * 2 + 0].setPadding(0, 170, 0, 0);
                        if ( (i*2 + 1) != offers.size())
                            textViews[i * 2 + 1].setPadding(0, 170, 0, 0);
                    }

                    textViews[i * 2 + 0].setTextColor(Color.rgb(0,0,255));
                    if ( (i*2 + 1) != offers.size())
                        textViews[i * 2 + 1].setTextColor(Color.rgb(0,0,255));

                    innerLayout[i * 2 + 0].addView(textViews[i*2 + 0]);
                    if ( (i*2 + 1) != offers.size())
                        innerLayout[i * 2 + 1].addView(textViews[i*2 + 1]);

                    if (i==0) {

                        innerLayout[i * 2 + 0].setLayoutParams(new ActionBar.LayoutParams(328, 280));
                        if ((i * 2 + 1) != offers.size())
                            innerLayout[i * 2 + 1].setLayoutParams(new ActionBar.LayoutParams(328, 280));
                    }else {
                        innerLayout[i * 2 + 0].setLayoutParams(new ActionBar.LayoutParams(328, 300));
                        if ((i * 2 + 1) != offers.size())
                            innerLayout[i * 2 + 1].setLayoutParams(new ActionBar.LayoutParams(328, 300));
                    }

                    innerLayout[i * 2 + 0].setBackgroundResource(R.drawable.offer3);
                    if ( (i*2 + 1) != offers.size())
                        innerLayout[i * 2 + 1].setBackgroundResource(R.drawable.offer3);


                    hor[i].addView(innerLayout[i * 2 + 0]);
                    hor[i].addView(temp[i]);
                    if ( (i*2 + 1) != offers.size())
                        hor[i].addView(innerLayout[i * 2 + 1]);

                    objFirstLinearLayout.addView(hor[i]);

                }

                for(int i=0;i<innerLayout.length;i++) {
                    final int finalI = i;
                    innerLayout[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(BestOffer.this, "Price: "+ offers.get(finalI).getPrice(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }




            }
        };
        //executing get reguest on api
        t1.execute("https://demo2126335.mockable.io/offers");


    }
}
