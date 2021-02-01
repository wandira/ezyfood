package com.example.socs.recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.socs.recyclerview.adapter.DrinksAdapter;
import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.menu.MainMenu;
import com.example.socs.recyclerview.model.Drinks;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DrinksAdapter dAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        setTitle("Binus EzyFood: Drinks");

        Intent intent = getIntent();
        int type = intent.getIntExtra("tipe",0);
        Drinks d1 = null,d2=null,d3=null;
        if(type==1)//drinks
        {setTitle("Binus EzyFood: Drinks");
            d1 = new Drinks("Coca Cola", R.drawable.cola, 100,1);
            d2 = new Drinks("Air Mineral", R.drawable.water, 100,1);
            d3 = new Drinks("Jus Buah", R.drawable.juice, 100,1);

        }else if(type==2)//snacks
        {setTitle("Binus EzyFood: Snacks");
            d1 = new Drinks("Choco Snack", R.drawable.img1, 200,1);
            d2 = new Drinks("Cheese Snack", R.drawable.img2, 200,1);
            d3 = new Drinks("Tiramisu Snack", R.drawable.img3, 200,1);
        }else if(type==3)//foods
        {setTitle("Binus EzyFood: Foods");
            d1 = new Drinks("Sushi", R.drawable.sushi, 300,1);
            d2 = new Drinks("Tempe", R.drawable.tempe, 300,1);
            d3 = new Drinks("Ayam Goreng", R.drawable.ayam, 300,1);
        }
 		ArrayList<Drinks> listDrinks = new ArrayList<>();
            listDrinks.add(d1);
            listDrinks.add(d2);
            listDrinks.add(d3);

            //ngebuka recyclerview nya dengan isi adapter yg telah diisi arrlist berisi drinks
            recyclerView = findViewById(R.id.recyclerView);
            dAdapter = new DrinksAdapter(listDrinks, this);
            recyclerView.setAdapter(dAdapter);
//            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setLayoutManager(  new GridLayoutManager(this, 2));


        Button keMyOrder = (Button) findViewById(R.id.btnMyOrder);
        keMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int12 =new Intent(DrinksActivity.this, CartActivity.class);
                startActivity(int12);
            }
        });
    }
}
