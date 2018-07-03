package com.example.abusalameh.myapplication.models;
/*
 Bread model to save informations gathered from api
 */
public class breadmodel {
    private String name ;
    private String price ;
    private String image_url;
    public breadmodel() {
    }


    public breadmodel(String name, String price, String image_url) {
        this.name = name;
        this.price = price;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "bread{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
