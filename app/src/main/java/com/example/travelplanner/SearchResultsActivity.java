package com.example.travelplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchResultsActivity extends AppCompatActivity implements TravelPackageAdapter.onPackageClickListener{

    RecyclerView result_recycler_view;
    List<TravelPackage> filteredPackages;
    TextView no_results_message;
    ProgressBar progressBar;

    //GET DESIGN LAYOUT ID FROM THE ADATER IN RECYCLER VIEW

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_results);

        no_results_message = findViewById(R.id.no_results_message);
        progressBar = findViewById(R.id.progress_bar);
        result_recycler_view = findViewById(R.id.recycler_view);
        result_recycler_view.setLayoutManager(new LinearLayoutManager(this));


        filteredPackages = (List<TravelPackage>) getIntent().getSerializableExtra("FILTERED_PACKAGES");


        result_recycler_view.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);

                        if(filteredPackages != null && !filteredPackages.isEmpty()){
                            TravelPackageAdapter adapter = new TravelPackageAdapter(filteredPackages,SearchResultsActivity.this);
                            result_recycler_view.setAdapter(adapter);
                            result_recycler_view.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }).start();

    }

    @Override
    public void onPackageClick(TravelPackage travelPackage) {
        Intent intent = new Intent(this, PackageDetailsActivity.class);
        intent.putExtra("TRAVEL_PACKAGE",travelPackage);
        startActivity(intent);
    }

}