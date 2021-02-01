package com.example.socs.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socs.recyclerview.Preference;
import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.menu.MainMenu;
import com.example.socs.recyclerview.model.Drinks;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ImageView imgViewDetil;
    TextView txtNameDetil;
    TextView txtPriceDetil;
    EditText txtQtyDetil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        setTitle("Binus EzyFood: Order");

        imgViewDetil = findViewById(R.id.imgViewDetil);
        txtNameDetil = findViewById(R.id.txtDetil);
        txtPriceDetil = findViewById(R.id.txtPrice);
        txtQtyDetil = findViewById(R.id.txtQty);
        Intent intent = getIntent();

        final Drinks drinks;
        drinks = (Drinks) intent.getSerializableExtra("drink");
        imgViewDetil.setImageResource(drinks.getThumbnail());
        txtNameDetil.setText(drinks.getDrinkName());
        String harga="Total: Rp. "+ String.valueOf(drinks.getPrice());
        txtPriceDetil.setText(harga);
//        txtPriceDetil.setText("Total=Rp. " +(String.valueOf(drinks.getPrice()));

        Button keMyOrder = (Button) findViewById(R.id.btnAddToCart);
        keMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ambil value edittextnya terus simpan ke object drinks
                String qtyTemp =txtQtyDetil.getText().toString();
                if (qtyTemp==null){
                    Toast.makeText(OrderActivity.this, "Please insert quantity", Toast.LENGTH_SHORT).show();
                    return;
                }

                int quantity = Integer.parseInt(qtyTemp);
                if (quantity==0){
                    Toast.makeText(OrderActivity.this, "Please insert quantity", Toast.LENGTH_SHORT).show();
                    return;
                }

                drinks.setQty(quantity);

                Preference p = new Preference(OrderActivity.this);
                ArrayList<Drinks> arr = p.getOrder();
                arr.add(drinks);
                p.setOrder(arr);
                Intent int12 =new Intent(OrderActivity.this, CartActivity.class);
                startActivity(int12);
            }
        });

        Button keOrderMore = (Button) findViewById(R.id.btnOrderMore);
        keOrderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int12 =new Intent(OrderActivity.this, MainMenu.class);
                startActivity(int12);
            }
        });
    }
}
