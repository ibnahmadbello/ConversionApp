package com.example.ibnahmad.conversionapp;

public class Currency {

    private String currency_name;
    private int currency_image;

    public Currency(String currency_name, int currency_image){
        this.currency_name = currency_name;
        this.currency_image = currency_image;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }

    public int getCurrency_image() {
        return currency_image;
    }

    public void setCurrency_image(int currency_image) {
        this.currency_image = currency_image;
    }





}
