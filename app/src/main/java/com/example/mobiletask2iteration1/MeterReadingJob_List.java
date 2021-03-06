package com.example.mobiletask2iteration1;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MeterReadingJob_List {
    private static ArrayList<MeterReadingJob> DisplayList = new ArrayList<>();

    public static ArrayList<MeterReadingJob> GetDisplayList() {
        return DisplayList;
    }

    /**
     * This will add MeterReadingJob to the DisplayList
     * @param Job MeterReadingJob to add to the DisplayList
     */
    public static void AddToList(MeterReadingJob Job) {
        DisplayList.add(Job);
    }


    /**
     * This will take a new MeterReadingJob will the replace the old MeterReadingJob
     * @param newJob MeterReadingJob that will replace the old MeterReadingJob
     * @param oldJob The old MeterReadingJob the will be replaced
     */
    public static void ReplaceJob(MeterReadingJob newJob, MeterReadingJob oldJob) {
        Integer indexItem = DisplayList.indexOf(oldJob);
        for (MeterReadingJob job : DisplayList) {
            if (job.equals(oldJob)){
                DisplayList.add(indexItem+1, newJob);
                DisplayList.remove(oldJob);
                break;
            }
        }
    }

    /**
     * This will save the data stored in DisplayList into a Json file
     * @param ct Context
     */
    // Save And Load The Display List
    public static void SaveData(Context ct) {
        Context context = ct;
        SharedPreferences sharedPreferences = ct.getSharedPreferences("shared preferences", ct.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(DisplayList);
        editor.putString("task list", json);
        editor.apply();
    }

    /**
     * This will load the data stored in DisplayList from a Json file
     * @param ct Context
     */
    public static void LoadData(Context ct){
        SharedPreferences sharedPreferences = ct.getSharedPreferences("shared preferences", ct.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<MeterReadingJob>>() {
        }.getType();
        DisplayList = gson.fromJson(json, type);
    }

    /**
     * This will sort DisplayList by date in descending
     */
    // Different ways to sort the Display list
    public static void SortByDate(){
        Collections.sort(DisplayList, new Comparator<MeterReadingJob>() {
            @Override
            public int compare(MeterReadingJob a, MeterReadingJob b) {
                // Returning the value after comparing the objects
                // this will sort the data in Descending order
                return b.getDeadlineDate().compareTo(a.getDeadlineDate());
            }
        });
    }

    /**
     * This will sort the DisplayList in by Job Status in descending order
     */
    public static void SortByJobCompleted() {
        Collections.sort(DisplayList, new Comparator<MeterReadingJob>() {
            @Override
            public int compare(MeterReadingJob JobStat1, MeterReadingJob JobStat2) {
                // Returning the value after comparing the objects
                // this will sort the data in Descending order
                return Boolean.compare(JobStat1.getJobStatus(),JobStat2.getJobStatus());
            }
        });
    }

    /**
     * Output all items in the Display list into a string
     */
    @Override
    public String toString() {
        String output = null;
        for (MeterReadingJob jobs: DisplayList) {
            output += jobs.getID() + "";
        }
        return output + "\n";
    }
}
