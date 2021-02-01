package com.example.socs.recyclerview.model;

import java.io.Serializable;

public class Drinks implements Serializable {
    private String drinkName;
    private int thumbnail;
    private int price;
    private int qty;

    public Drinks(String drinkName, int thumbnail, int price, int qty) {
//        public Drinks(String drinkName, int thumbnail) {
        this.drinkName = drinkName;
        this.thumbnail = thumbnail;
        this.price = price;
        this.qty = qty;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
