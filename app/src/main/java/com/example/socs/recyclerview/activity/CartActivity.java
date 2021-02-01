package com.example.socs.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socs.recyclerview.Preference;
import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.adapter.CartAdapter;
import com.example.socs.recyclerview.model.Drinks;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CartAdapter cAdapter;
//    int total;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setTitle("Binus EzyFood: MyOrder");
        //Get Array of Orders
        Preference p = new Preference(CartActivity.this);
        ArrayList<Drinks> arr = p.getOrder();

        //Texts
        TextView txtTotal = findViewById(R.id.txtTotal);
        txtTotal.setText("Total=Rp. " + p.getTotal());
        int noOrder=0;
        if(arr.isEmpty()){
            noOrder=1;
        }
        //Buttons
        Button keOrderComplete = (Button) findViewById(R.id.btnPayNow);
        final int finalNoOrder = noOrder;
        keOrderComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(finalNoOrder ==1){
                    Toast.makeText(CartActivity.this, "Nothing to Pay. Cart Empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(CartActivity.this, "Order Completed", Toast.LENGTH_SHORT).show();

                Intent int12 =new Intent(CartActivity.this, OrderComplete.class);
                startActivity(int12);
            }
        });

        //Showing List of Orders
        recyclerView = findViewById(R.id.recyclerView);
        cAdapter = new CartAdapter(arr, this);
        recyclerView.setAdapter(cAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
