package com.example.mobiletask2iteration1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiletask2iteration1.Pages.ViewJob;

import java.io.Serializable;
import java.util.ArrayList;

public class MeterReading_RecyclerAdapter extends RecyclerView.Adapter<MeterReading_RecyclerAdapter.MyViewHolder> implements Serializable {

    private ArrayList<MeterReadingJob> JobDataList;
    private Context context;


    // Collects the display items on list_items.xml
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView JobID;
        private ConstraintLayout mainLayout;
        private ImageButton ImgViewRemoveIcn;
        private ImageButton ImgViewMoreIcn;

        public MyViewHolder(final View view) {
            super(view);
            JobID = view.findViewById(R.id.JobID);
            mainLayout = view.findViewById(R.id.mainLayout);
            ImgViewRemoveIcn = view.findViewById(R.id.imageButton_Remove);
            ImgViewMoreIcn = view.findViewById(R.id.imageButton_Edit);
        }
    }

    /**
     * @param ct The activity class context
     * @param JobDataList This will display a MeterReadingJobs array list
     */
    public MeterReading_RecyclerAdapter(Context ct, ArrayList<MeterReadingJob> JobDataList){
        this.JobDataList = JobDataList;
        this.context = ct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MeterReading_RecyclerAdapter.MyViewHolder holder, int position) {
        MeterReadingJob Selected_MeterReadingJob = JobDataList.get(position);

        //Display Data in a row
        holder.JobID.setText(Selected_MeterReadingJob.getID());

        //Remove Job when cross is pressed
        holder.ImgViewRemoveIcn.setOnClickListener(view ->{
            removeJob(Selected_MeterReadingJob);
            MeterReadingJob_List.SaveData(context);
        });

        //Pass through the MeterReadingJob pressed on to the View Job Activity
        holder.ImgViewMoreIcn.setOnClickListener(view -> {
            Intent intent = new Intent(context, ViewJob.class);
            intent.putExtra("User", Selected_MeterReadingJob);
            intent.putExtra("OldJob", Selected_MeterReadingJob);
            context.startActivity(intent);
        });
    }

    private void removeJob(MeterReadingJob Job) {
        JobDataList.remove(Job);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return JobDataList.size();
    }
}
