package com.example.mobiletask2iteration1.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobiletask2iteration1.MeterReadingJob;
import com.example.mobiletask2iteration1.MeterReadingJob_List;
import com.example.mobiletask2iteration1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class ViewJob extends AppCompatActivity {

    private EditText DeadlineDate;
    private TextInputEditText Address, MeterLocation, UtilComp, CustName, ID, MeterReadResult;
    private Spinner MeterType;
    public MeterReadingJob Job, OldJob;
    private CheckBox JobStat;
    private FloatingActionButton saveFAB, emailFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getUI_Elements();
        getDataFromIntent();
        SaveFAB_Pressed();

        DisplayData();

        emailFAB.setOnClickListener(view -> {
            sendEmail();
        });
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
        Job.setDeadlineDate_String(DeadlineDate.getText().toString());
        Job.setMeterType(MeterType.getSelectedItemPosition());
        Job.setAddress(Address.getText().toString());
        Job.setUtilComp(UtilComp.getText().toString());
        Job.setMeterLocation(MeterLocation.getText().toString());
        Job.setJobStatus(JobStat.isChecked());
        Job.setMeterReadingResult(MeterReadResult.getText().toString());
        Job.setCustomerName(CustName.getText().toString());
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
        emailFAB = findViewById(R.id.floatingActionButton_email);

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
        DeadlineDate.setText(Job.getDeadlineDate_toString());
        MeterType.setSelection(Job.getTypeOfMeter());
        Address.setText(Job.getJobAddress());
        MeterLocation.setText(Job.getMeterLocation());
        UtilComp.setText(Job.getUtilityCompany());
        JobStat.setChecked(Job.getJobStatus());
        CustName.setText(Job.getNameOfCustomer());
        MeterReadResult.setText(Job.getMeterReadingResult());
    }

    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_TEXT, Job.toString());
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}