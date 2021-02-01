package com.example.socs.recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socs.recyclerview.Preference;
import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.adapter.CartAdapter;
import com.example.socs.recyclerview.adapter.CompleteAdapter;
import com.example.socs.recyclerview.menu.MainMenu;
import com.example.socs.recyclerview.model.Drinks;

import java.util.ArrayList;

public class OrderComplete extends AppCompatActivity {
    RecyclerView recyclerView;
    CompleteAdapter completeAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        Preference p = new Preference(OrderComplete.this);
        ArrayList<Drinks> arr = p.getOrder();

        //Texts
        TextView txtTotal = findViewById(R.id.txtTotal);
        txtTotal.setText("Total=Rp. " + p.getTotal());

        //Buttons
        Button keMainMenu = (Button) findViewById(R.id.btnMainMenu);
        keMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Emptying array orderan nya
                Preference p = new Preference(OrderComplete.this);
                ArrayList<Drinks> arr = null;
                p.setOrder(arr);

                //Notif
                Toast.makeText(OrderComplete.this, "Back to Main Menu", Toast.LENGTH_SHORT).show();

                //Pindah ke Main Menu
                Intent int12 =new Intent(OrderComplete.this, MainMenu.class);
                startActivity(int12);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        completeAdapter = new CompleteAdapter(arr, this);
        recyclerView.setAdapter(completeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}