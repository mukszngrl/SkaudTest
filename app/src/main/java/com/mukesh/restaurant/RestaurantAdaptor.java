package com.mukesh.restaurant;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mukesh.restaurant.Models.RestaurantsDO;

import java.util.ArrayList;

public class RestaurantAdaptor extends RecyclerView.Adapter<RestaurantAdaptor.MyViewHolder> {
    private Context context;
    private ArrayList<RestaurantsDO> arrRestaurants;

    public RestaurantAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_cell, viewGroup, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int i) {
        RestaurantsDO restaurantsDO = arrRestaurants.get(i);
        if (restaurantsDO != null) {
            myViewHolder.tvRestaurantName.setText(restaurantsDO.getName());
            myViewHolder.tvMenu.setText(restaurantsDO.getName());
            String path;
            if (restaurantsDO.getPhotos() != null && restaurantsDO.getPhotos().size() > 0)
                path = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + restaurantsDO.getPhotos().get(0).getPhoto_reference() + "&sensor=false&key=AIzaSyD0AQBJ_BwInY5Tv_0tqGPJIWL7FcllnH0";
            else
                path = restaurantsDO.getIcon();
            Glide.with(context)
                    .load(path)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(myViewHolder.ivRestaurantPic);
            myViewHolder.tvRating.setText(restaurantsDO.getRating() + "");

            if (restaurantsDO.getOpening_hours() != null) {
                if (restaurantsDO.getOpening_hours().isOpen_now())
                    myViewHolder.tvStatus.setText("Open");
                else
                    myViewHolder.tvStatus.setText("Closed");
            } else
                myViewHolder.tvStatus.setText("Closed");
        }
    }

    @Override
    public int getItemCount() {
        if (arrRestaurants == null) {
            return 0;
        }
        return arrRestaurants.size();
    }

    public void refresh(ArrayList<RestaurantsDO> arrRestaurants) {
        this.arrRestaurants = arrRestaurants;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivRestaurantPic;
        TextView tvRestaurantName, tvMenu, tvPrice, tvStatus, tvVariant, tvDescription, tvRating;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);

            ivRestaurantPic = itemView.findViewById(R.id.ivRestaurantPic);
            tvRestaurantName = itemView.findViewById(R.id.tvRestaurantName);
            tvMenu = itemView.findViewById(R.id.tvMenu);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvVariant = itemView.findViewById(R.id.tvVariant);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvRating = itemView.findViewById(R.id.tvRating);
        }
    }
}
