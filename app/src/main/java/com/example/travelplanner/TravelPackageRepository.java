package com.example.travelplanner;

import java.util.ArrayList;
import java.util.List;

public class TravelPackageRepository {
    public List<TravelPackage> getTravelPackages(){
        List<TravelPackage> travelPackages = new ArrayList<>();

        // Beach Getaways
        travelPackages.add(new TravelPackage(R.drawable.t3,"Maldives", "Relax on beautiful beaches with crystal clear waters.", 1500.0f, 4.8f, "Beach Getaways"));
        travelPackages.add(new TravelPackage(R.drawable.t3,"Bora Bora, French Polynesia", "Luxurious overwater bungalows and lagoons.", 2500.0f, 4.9f,  "Beach Getaways"));
        travelPackages.add(new TravelPackage(R.drawable.t3,"Maui, Hawaii", "Enjoy surfing and stunning sunsets.", 1800.0f, 4.7f,  "Beach Getaways"));
        travelPackages.add(new TravelPackage(R.drawable.t3,"Phuket, Thailand", "White sand beaches and vibrant nightlife.", 1200.0f, 4.6f, "Beach Getaways"));
        travelPackages.add(new TravelPackage(R.drawable.t3,"Santorini, Greece", "Breathtaking caldera views and Greek culture.", 1600.0f, 4.8f,  "Beach Getaways"));

        // Mountains
        travelPackages.add(new TravelPackage(R.drawable.t2, "Swiss Alps, Switzerland", "Snow-covered peaks and picturesque villages.", 2000.0f, 4.9f, "Mountains"));
        travelPackages.add(new TravelPackage(R.drawable.t2, "Rockies, Colorado", "Hiking and breathtaking mountain scenery.", 1500.0f, 4.7f, "Mountains"));
        travelPackages.add(new TravelPackage(R.drawable.t2, "Himalayas, Nepal", "Explore the world's highest peaks.", 1800.0f, 4.8f, "Mountains"));
        travelPackages.add(new TravelPackage(R.drawable.t2, "Dolomites, Italy", "Rock climbing and charming mountain villages.", 1600.0f, 4.6f, "Mountains"));
        travelPackages.add(new TravelPackage(R.drawable.t2, "Andes, Peru", "Discover the Andes and Machu Picchu.", 1900.0f, 4.9f, "Mountains"));

        // City Tours
        travelPackages.add(new TravelPackage(R.drawable.t4, "New York City, USA", "Explore the vibrant city life and iconic landmarks.", 1200.0f, 4.5f, "City Tours"));
        travelPackages.add(new TravelPackage(R.drawable.t4, "Tokyo, Japan", "Dive into technology, anime, and rich culture.", 1400.0f, 4.7f, "City Tours"));
        travelPackages.add(new TravelPackage(R.drawable.t4, "Paris, France", "The city of love and the Eiffel Tower.", 1700.0f, 4.8f, "City Tours"));
        travelPackages.add(new TravelPackage(R.drawable.t4, "Rome, Italy", "A journey through ancient history.", 1500.0f, 4.6f, "City Tours"));
        travelPackages.add(new TravelPackage(R.drawable.t4, "Barcelona, Spain", "Modernist architecture and vibrant culture.", 1600.0f, 4.7f, "City Tours"));

        // Wildlife Safaris
        travelPackages.add(new TravelPackage(R.drawable.t5, "Maasai Mara, Kenya", "Witness the great migration.", 2500.0f, 4.9f, "Wildlife Safaris"));
        travelPackages.add(new TravelPackage(R.drawable.t5, "Kruger National Park, South Africa", "Spot the Big Five animals.", 2200.0f, 4.7f, "Wildlife Safaris"));
        travelPackages.add(new TravelPackage(R.drawable.t5, "Chobe National Park, Botswana", "Famous for elephants and boat safaris.", 2300.0f, 4.8f, "Wildlife Safaris"));
        travelPackages.add(new TravelPackage(R.drawable.t5, "Ranthambore, India", "Perfect for tiger sightings.", 1500.0f, 4.6f, "Wildlife Safaris"));

        // Cruise Packages
//        travelPackages.add(new TravelPackage("https://example.com/caribbeancruise.jpg", "Caribbean Cruise", "Discover tropical islands and beaches.", 3000.0, 4.9f, "Cruise Packages"));
//        travelPackages.add(new TravelPackage("https://example.com/mediterraneancruise.jpg", "Mediterranean Cruise", "Explore Europe’s beautiful coasts.", 2800.0, 4.8f, "Cruise Packages"));
//        travelPackages.add(new TravelPackage("https://example.com/alaskacruise.jpg", "Alaska Cruise", "Sail through icy glaciers and wildlife.", 2600.0, 4.7f, "Cruise Packages"));
//        travelPackages.add(new TravelPackage("https://example.com/norwegianfjords.jpg", "Norwegian Fjords Cruise", "Majestic fjords and waterfalls.", 2900.0, 4.9f, "Cruise Packages"));
//        travelPackages.add(new TravelPackage("https://example.com/balticsea.jpg", "Baltic Sea Cruise", "Historic cities and Nordic beauty.", 2500.0, 4.8f, "Cruise Packages"));

        return travelPackages;
    }
}
