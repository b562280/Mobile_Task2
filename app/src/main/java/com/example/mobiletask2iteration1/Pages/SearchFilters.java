package com.example.mobiletask2iteration1.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.mobiletask2iteration1.R;

public class SearchFilters extends AppCompatActivity {

    private Button JobStatSearch, DeadlineDateSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_filters);

        getUI_Elements();

    }

    private void getUI_Elements() {
        JobStatSearch.findViewById(R.id.button_SearchJobStat);
        DeadlineDateSearch.findViewById(R.id.button_SearchDeadlineDate);
    }
}