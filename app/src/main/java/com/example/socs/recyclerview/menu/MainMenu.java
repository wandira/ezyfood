package com.example.socs.recyclerview.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.activity.CartActivity;
import com.example.socs.recyclerview.activity.DrinksActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setTitle("Binus EzyFood");

//MENUJU DRINKS
        Button keDrinks = (Button) findViewById(R.id.btnDrinks);
        keDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int14 = new Intent(MainMenu.this, DrinksActivity.class);
                int14.putExtra("tipe",1);
                startActivity(int14);
            }
        });

//MENUJU SNACKS
        Button keSnacks = (Button) findViewById(R.id.btnSnacks);
        keSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int14 = new Intent(MainMenu.this, DrinksActivity.class);
                int14.putExtra("tipe",2);
                startActivity(int14);
            }
        });
//MENUJU FOODS
        Button keFoods = (Button) findViewById(R.id.btnFoods);
        keFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int14 = new Intent(MainMenu.this, DrinksActivity.class);
                int14.putExtra("tipe",3);
                startActivity(int14);
            }
        });

        // Menuju CART (myorder)
        Button keMyOrder = (Button) findViewById(R.id.btnMyOrder);
        keMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int12 = new Intent(MainMenu.this, CartActivity.class);
                startActivity(int12);
            }
        });
    }
}