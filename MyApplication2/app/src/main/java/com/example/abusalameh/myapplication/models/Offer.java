package com.example.abusalameh.myapplication.models;

import java.util.ArrayList;

/*
 offers model to save informations gathered from api
 */

public class Offer {
    ArrayList<String> itemlist;
    int price;

    public Offer(){}

    public Offer(ArrayList<String> itemlist, int price) {
        this.itemlist = itemlist;
        this.price = price;
    }

    public ArrayList<String> getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList<String> itemlist) {
        this.itemlist = itemlist;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String itemList() {
        String list = "";
        for (int i=0;i<itemlist.size();i++) {
            list+= itemlist.get(i);
            if (i != itemlist.size()-1)
                list+= ", ";

        }
        return list;
    }
}
