package com.example.mobiletask2iteration1.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiletask2iteration1.MeterReadingJob;
import com.example.mobiletask2iteration1.MeterReadingJob_List;
import com.example.mobiletask2iteration1.MeterReading_RecyclerAdapter;
import com.example.mobiletask2iteration1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.DoubleAdder;

public class ViewJob extends AppCompatActivity {

    private TextView ID, DeadlineDate, MeterType, Address, MeterLocation,
            UtilComp, CustName;
    public MeterReadingJob Job, OldJob;
    private CheckBox JobStat;
    private FloatingActionButton saveFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getUI_Elements();
        getDataFromIntent();
        SaveFAB_Pressed();

        DisplayData();
    }

    private void SaveFAB_Pressed() {
        saveFAB.setOnClickListener(view -> {
            //Update Job Information
            Job.setJobStatus(JobStat.isChecked());
            Job.setID(420);
            //Update List and Start homepage
            MeterReadingJob_List.ReplaceJob(Job, OldJob);
            MeterReadingJob_List.SaveData(this);
            Intent intent = new Intent(this, HomePage.class);
            this.startActivity(intent);
        });
    }

    private void getUI_Elements() {
        ID = findViewById(R.id.ViewJob_JobID);
        DeadlineDate = findViewById(R.id.viewJob_DeadLineDate);
        MeterType = findViewById(R.id.viewJob_MeterType);
        Address = findViewById(R.id.viewJob_Address);
        MeterLocation = findViewById(R.id.viewJob_MeterLocation);
        UtilComp = findViewById(R.id.viewJob_UtilComp);
        JobStat = findViewById(R.id.checkBox_JobStat);
        CustName = findViewById(R.id.viewJob_CustName);
        saveFAB = findViewById(R.id.floatingActionButton_Save);
    }

    private void getDataFromIntent() {
        if (getIntent().hasExtra("User")) {
            Job = (MeterReadingJob) getIntent().getSerializableExtra("User");
            OldJob = (MeterReadingJob) getIntent().getSerializableExtra("OldJob");
        }
        else {
            Toast.makeText(this, "no data", Toast.LENGTH_LONG).show();
        }
    }

    private void DisplayData() {
        ID.setText(Job.getID());
        DeadlineDate.setText(Job.getDeadlineDate());
        MeterType.setText(Job.getTypeOfMeter());
        Address.setText(Job.getJobAddress());
        MeterLocation.setText(Job.getMeterLocation());
        UtilComp.setText(Job.getUtilityCompany());
        JobStat.setChecked(Job.getJobStatus());
        CustName.setText(Job.getNameOfCustomer());

    }
}