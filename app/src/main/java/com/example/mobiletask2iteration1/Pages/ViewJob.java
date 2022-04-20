package com.example.mobiletask2iteration1.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiletask2iteration1.MeterReadingJob;
import com.example.mobiletask2iteration1.MeterReadingJob_List;
import com.example.mobiletask2iteration1.MeterReading_RecyclerAdapter;
import com.example.mobiletask2iteration1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.DoubleAdder;

public class ViewJob extends AppCompatActivity {

    private EditText DeadlineDate;
    private TextInputEditText Address, MeterLocation, UtilComp, CustName, ID, MeterReadResult;
    private Spinner MeterType;
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
            getDataFromUI();
            //Update List and Start homepage
            MeterReadingJob_List.ReplaceJob(Job, OldJob);
            MeterReadingJob_List.SaveData(this);
            Intent intent = new Intent(this, HomePage.class);
            this.startActivity(intent);
        });
    }

    private void getDataFromUI(){
        Job.setID(Integer.parseInt(ID.getText().toString()));
        Job.setDeadlineDate(DeadlineDate.getText().toString());
        Job.setMeterType(MeterType.getSelectedItemPosition());
        Job.setAddress(Address.getText().toString());
        Job.setUtilComp(UtilComp.getText().toString());
        Job.setMeterLocation(MeterLocation.getText().toString());
        Job.setJobStatus(JobStat.isChecked());
        Job.setMeterReadingResult(MeterReadResult.getText().toString());
    }

    private void getUI_Elements() {
        ID = findViewById(R.id.viewJob_JobID);
        DeadlineDate = findViewById(R.id.viewJob_DeadLineDate);

        MeterType = findViewById(R.id.viewJob_MeterType);
        String[] items = new String[]{"Gas", "Electric", "Solar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        MeterType.setAdapter(adapter);

        Address = findViewById(R.id.viewJob_Address);
        MeterLocation = findViewById(R.id.viewJob_MeterLocation);
        UtilComp = findViewById(R.id.viewJob_UtilComp);
        JobStat = findViewById(R.id.checkBox_JobStat);
        CustName = findViewById(R.id.viewJob_CustName);
        saveFAB = findViewById(R.id.floatingActionButton_Save);

        MeterReadResult = findViewById(R.id.viewJob_InputMeter);
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
        MeterType.setSelection(Job.getTypeOfMeter());
        Address.setText(Job.getJobAddress());
        MeterLocation.setText(Job.getMeterLocation());
        UtilComp.setText(Job.getUtilityCompany());
        JobStat.setChecked(Job.getJobStatus());
        CustName.setText(Job.getNameOfCustomer());
        MeterReadResult.setText(Job.getMeterReadingResult());
    }
}