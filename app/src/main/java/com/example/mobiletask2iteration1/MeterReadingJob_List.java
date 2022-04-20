package com.example.mobiletask2iteration1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MeterReadingJob_List {
    private static ArrayList<MeterReadingJob> DisplayList = new ArrayList<>();

    public static ArrayList<MeterReadingJob> GetDisplayList() {
        return DisplayList;
    }

    public static void AddToList(MeterReadingJob Job) {
        DisplayList.add(Job);
    }

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

    public static void SaveData(Context ct) {
        Context context = ct;
        SharedPreferences sharedPreferences = ct.getSharedPreferences("shared preferences", ct.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(DisplayList);
        editor.putString("task list", json);
        editor.apply();
    }

    public static void LoadData(Context ct){
        SharedPreferences sharedPreferences = ct.getSharedPreferences("shared preferences", ct.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<MeterReadingJob>>() {
        }.getType();
        DisplayList = gson.fromJson(json, type);
    }

    @Override
    public String toString() {
        String output = null;
        for (MeterReadingJob jobs: DisplayList) {
            output += jobs.getID() + "";
        }
        return output + "\n";
    }
}
