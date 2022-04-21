package com.example.mobiletask2iteration1.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.mobiletask2iteration1.MeterReadingJob_List;
import com.example.mobiletask2iteration1.R;

public class SearchFilters extends AppCompatActivity {

    private Button JobStatSearch, DeadlineDateSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filters);

        getUI_Elements();

        JobStatFilter_Pressed();

        DeadlineDateFilter_Pressed();
    }

    private void DeadlineDateFilter_Pressed() {
        DeadlineDateSearch.setOnClickListener(view -> {
            MeterReadingJob_List.SortByDate();
            returnToHomepage();
        });
    }

    private void JobStatFilter_Pressed() {
        JobStatSearch.setOnClickListener(view -> {
            MeterReadingJob_List.SortByJobCompleted();
            returnToHomepage();
        });
    }

    private void returnToHomepage() {
        Intent intent = new Intent(this, HomePage.class);
        this.startActivity(intent);
    }

    private void getUI_Elements() {
        JobStatSearch = findViewById(R.id.button_SearchJobStat);
        DeadlineDateSearch = findViewById(R.id.button_SearchDeadlineDate);
    }
}