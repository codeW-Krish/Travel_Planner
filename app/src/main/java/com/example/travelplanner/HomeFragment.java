package com.example.travelplanner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment implements TravelPackageAdapter.onPackageClickListener{

    private RecyclerView recyclerView;
    private List<TravelPackage> travelPackageList;

    TextView et_date, et_time;
    AutoCompleteTextView actv_destination;
    Button btn_search;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        TravelPackageRepository repository = new TravelPackageRepository();
        travelPackageList = repository.getTravelPackages();


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        actv_destination = view.findViewById(R.id.actv_destination);
        et_date = view.findViewById(R.id.et_date);
        et_time = view.findViewById(R.id.et_time);
        btn_search = view.findViewById(R.id.btn_search);

        et_date.setInputType(InputType.TYPE_NULL);
        et_time.setInputType(InputType.TYPE_NULL);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        TravelPackageAdapter adapter = new TravelPackageAdapter(travelPackageList,this,R.layout.travel_package);
        recyclerView.setAdapter(adapter);

        String[] places_with_category = getResources().getStringArray(R.array.places_with_categories);
        ArrayAdapter<String> actv_adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_dropdown_item_1line,places_with_category);
        actv_destination.setAdapter(actv_adapter);

        setTextWatchers();

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String selected_date = i2+"/"+(i1+1)+"/"+i;
                        et_date.setText(selected_date);
                    }
                },year,month,day).show();
            }
        });

        et_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int min = calendar.get(Calendar.MINUTE);

                new TimePickerDialog(requireContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        String selected_time = i+":"+i1;
                        et_time.setText(selected_time);
                    }
                },hour,min,false).show();
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValidate = validateInputs();

                if (isValidate) {
                    String query = actv_destination.getText().toString();
                    filterAndNavigate(query);

                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            actv_destination.setText("");
                            et_date.setText("");
                            et_time.setText("");
                        }
                    },300);

                }
            }
        });
        return view;
    }

    private void setTextWatchers(){
        actv_destination.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                actv_destination.setError(null);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().trim().isEmpty()){
                    actv_destination.setError("Destination cannot be Empty!");
                }else{
                    actv_destination.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private boolean validateInputs(){
        boolean isValid = true;

        if(actv_destination.getText().toString().trim().isEmpty()){
            actv_destination.setError("Destination cannot be Empty!");
            isValid = false;
        }

        if(et_date.getText().toString().trim().isEmpty()){
            et_date.setError("Date cannot be Empty!");
            isValid = false;
        }else{
            et_date.setError(null);
        }

        if(et_time.getText().toString().trim().isEmpty()){
            et_time.setError("Time cannot be Empty!");
            isValid = false;
        }else{
            et_time.setError(null);
        }

        return isValid;
    }

    private void filterAndNavigate(String query){
        String[] parts = query.split(",");
        if(parts.length > 1){
            String category = parts[1].trim();
            List<TravelPackage> filteredList = new ArrayList<>();

            for(TravelPackage travelPackage:travelPackageList){
                if(travelPackage.getCategory().equalsIgnoreCase(category)){
                    filteredList.add(travelPackage);
                }
            }

            Intent intent = new Intent(getContext(), SearchResultsActivity.class);
            intent.putExtra("FILTERED_PACKAGES",(ArrayList<TravelPackage>)filteredList);
            startActivity(intent);
        }else{
            Toast.makeText(getContext(), "Please Enter a Valid Destination", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPackageClick(TravelPackage travelPackage) {
        Intent intent = new Intent(getContext(), PackageDetailsActivity.class);
        intent.putExtra("TRAVEL_PACKAGE", travelPackage);
        startActivity(intent);
    }
}