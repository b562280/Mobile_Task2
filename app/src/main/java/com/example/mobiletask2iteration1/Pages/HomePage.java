package com.example.mobiletask2iteration1.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mobiletask2iteration1.MeterReadingJob;
import com.example.mobiletask2iteration1.MeterReadingJob_List;
import com.example.mobiletask2iteration1.MeterReading_RecyclerAdapter;
import com.example.mobiletask2iteration1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.Random;

public class HomePage extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton AddJobFAB, syncListFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UI_Elements();

        syncListFAB_Pressed();

        setAdapter();

        AddJobFAB_Pressed();
    }

    private void UI_Elements() {
        recyclerView = findViewById(R.id.recyclerView);
        AddJobFAB = findViewById(R.id.addJob);
        syncListFAB = findViewById(R.id.syncList);
    }

    private void AddJobFAB_Pressed() {
        AddJobFAB.setOnClickListener(view -> {
            Random random = new Random();
            MeterReadingJob_List.AddToList(new MeterReadingJob(random.nextInt(99999),
                    0,
                    new Date(),
                    "jobAddress",
                    "meterLocation",
                    "utilityCompany",
                    false,
                    "nameOfCustomer"));
            setAdapter();
            MeterReadingJob_List.SaveData(this);
        });
    }

    private void setAdapter() {
        MeterReading_RecyclerAdapter adapter = new MeterReading_RecyclerAdapter(this,
                MeterReadingJob_List.GetDisplayList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void syncListFAB_Pressed(){
        syncListFAB.setOnClickListener(view -> {
            MeterReadingJob_List.LoadData(this);
            setAdapter();
        });
    }
}