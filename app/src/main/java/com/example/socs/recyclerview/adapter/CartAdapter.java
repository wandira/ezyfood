package com.example.socs.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socs.recyclerview.activity.CartActivity;
import com.example.socs.recyclerview.activity.OrderActivity;
import com.example.socs.recyclerview.Preference;
import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.model.Drinks;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    ArrayList<Drinks> listDrinks;
    Context ctx;

    public CartAdapter(ArrayList<Drinks> listDrinks, Context ctx) {
        this.listDrinks = listDrinks;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.cart_row, viewGroup, false);
        return new CartAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Drinks drinks = listDrinks.get(i);
        viewHolder.imgView.setImageResource(drinks.getThumbnail());
        viewHolder.txtName.setText(drinks.getDrinkName());
        String harga="Rp. "+ String.valueOf(drinks.getPrice());
        viewHolder.txtPrice.setText(harga);
//        viewHolder.txtPrice.setText(String.valueOf(drinks.getPrice()));
        String qt="x "+String.valueOf(drinks.getQty())+" qty";
        viewHolder.txtQty.setText(qt);
//        viewHolder.txtQty.setText(String.valueOf(drinks.getQty()));
        viewHolder.btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listDrinks.remove(i);
                Preference p = new Preference(ctx);
                p.setOrder(listDrinks);
                p.getTotal();//?update total tiap kali ngedelete gmn y??
                notifyDataSetChanged();
//                new CartActivity();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDrinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtName;
        TextView txtPrice;
        TextView txtQty;

        Button btnHapus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imageView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtQty = itemView.findViewById(R.id.txtQty);
            btnHapus = itemView.findViewById(R.id.btnHapus);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ctx, txtName.getText(), Toast.LENGTH_LONG).show();
                    int position = getAdapterPosition();
                    Drinks drinks = listDrinks.get(position);
                    Intent intent = new Intent(ctx, OrderActivity.class);
                    intent.putExtra("drink", drinks);
                    ctx.startActivity(intent);
                }
            });
        }
    }
}
