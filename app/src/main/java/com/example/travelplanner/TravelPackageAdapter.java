package com.example.travelplanner;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TravelPackageAdapter extends RecyclerView.Adapter<TravelPackageAdapter.ViewHolder>{

    private List<TravelPackage> travelPackageList;
    private onPackageClickListener listener;

    public interface onPackageClickListener{
        void onPackageClick(TravelPackage travelPackage);
    }

    public TravelPackageAdapter(List<TravelPackage> travelPackageList, onPackageClickListener listener){
        this.travelPackageList = travelPackageList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.travel_package,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TravelPackage travelPackage = travelPackageList.get(position);
        holder.title.setText(travelPackage.getTitle());
        holder.description.setText(travelPackage.getDescription());
        holder.price.setText("Price: "+travelPackage.getPrice()+" INR");
        holder.rating.setText("Rating: "+travelPackage.getRatings());
        holder.image.setImageResource(travelPackage.getImageUrl());
        holder.itemView.setOnClickListener(view -> listener.onPackageClick(travelPackage));
    }

    @Override
    public int getItemCount() {
        return travelPackageList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, description, price, rating;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.package_title);
            description = itemView.findViewById(R.id.package_description);
            price = itemView.findViewById(R.id.package_price);
            rating = itemView.findViewById(R.id.package_rating);
            image = itemView.findViewById(R.id.package_image);
        }
    }
}

