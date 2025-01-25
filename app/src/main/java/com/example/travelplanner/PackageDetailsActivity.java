package com.example.travelplanner;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class PackageDetailsActivity extends AppCompatActivity {

    TextView title, description, price, rating;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_package_details);

        TravelPackage travelPackage = (TravelPackage) getIntent().getSerializableExtra("TRAVEL_PACKAGE");

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        price = findViewById(R.id.price);
        rating = findViewById(R.id.rating);
        imageView = findViewById(R.id.image);

        assert travelPackage != null;
        String p = "Price: "+travelPackage.getPrice()+" INR";
        String r = "Rating: "+travelPackage.getRatings();
        assert travelPackage != null;
        title.setText(travelPackage.getTitle());
        description.setText(travelPackage.getDescription());
        price.setText(p);
        rating.setText(r);
        imageView.setImageResource(travelPackage.getImageUrl());

    }
}