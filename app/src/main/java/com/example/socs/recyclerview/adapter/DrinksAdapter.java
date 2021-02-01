package com.example.socs.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socs.recyclerview.activity.OrderActivity;
import com.example.socs.recyclerview.R;
import com.example.socs.recyclerview.model.Drinks;

import java.util.ArrayList;


public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder>{
    ArrayList<Drinks> listDrinks;
    Context ctx;

    public DrinksAdapter(ArrayList<Drinks> listDrinks, Context ctx) {
        this.listDrinks = listDrinks;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.item_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Drinks drinks = listDrinks.get(i);
        viewHolder.imgView.setImageResource(drinks.getThumbnail());
        viewHolder.txtName.setText(drinks.getDrinkName());
        String harga="Rp. "+ String.valueOf(drinks.getPrice());
        viewHolder.txtPrice.setText(harga);
//        viewHolder.txtPrice.setText(String.valueOf(drinks.getPrice()));
    }

    @Override
    public int getItemCount() {
        return listDrinks.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView txtName;
        TextView txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imageView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
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
