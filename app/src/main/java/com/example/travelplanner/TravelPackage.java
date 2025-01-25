package com.example.travelplanner;
import java.io.Serializable;

public class TravelPackage implements Serializable{
    private int imageUrl;
    private String title;
    private String description;
    private float price;
    private float ratings;
    private String category;


    public TravelPackage(int imageUrl, String title, String description, float price, float ratings,String category){
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.price = price;
        this.ratings = ratings;
        this.category = category;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public float getRatings() {
        return ratings;
    }

    public String getCategory() {
        return category;
    }
}
