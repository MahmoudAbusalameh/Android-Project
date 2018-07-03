package com.example.abusalameh.myapplication.models;

/*
 coupon model to save informations gathered from api
 */



public class Coupon {
    private String name;
    private String description;

    public Coupon() {
    }

    public Coupon(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
