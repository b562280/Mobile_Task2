package com.example.mobiletask2iteration1;

import org.junit.Test;

import static org.junit.Assert.*;

import android.util.Log;

import java.util.Date;
import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest_Iteration1 {

    @Test
    public void AddJobToList() {
        MeterReadingJob JOB = addJob();
        MeterReadingJob_List.AddToList(JOB);
        assertEquals(JOB,MeterReadingJob_List.GetDisplayList().get(0));
    }

    @Test
    public void removeJobFromList() {
        MeterReadingJob JOB = addJob();
        MeterReadingJob_List.AddToList(JOB);
        MeterReadingJob_List.GetDisplayList().remove(JOB);
        assertEquals(0, MeterReadingJob_List.GetDisplayList().size());
    }

    @Test
    public void returnID() {
        Integer JobID = 23;

        MeterReadingJob JOB = new MeterReadingJob(
                JobID,
                0,
                new Date(),
                "jobAddress",
                "meterLocation",
                "utilityCompany",
                false,
                "nameOfCustomer");

        assertEquals(JobID.toString() ,JOB.getID());
    }

    public MeterReadingJob addJob() {
        Random random = new Random();
        return new MeterReadingJob(
                random.nextInt(99999),
                0,
                new Date(),
                "jobAddress",
                "meterLocation",
                "utilityCompany",
                false,
                "nameOfCustomer");
    }
}