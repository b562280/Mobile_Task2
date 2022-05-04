package com.example.mobiletask2iteration1;

import static org.junit.Assert.assertEquals;

import com.example.mobiletask2iteration1.Pages.HomePage;

import org.junit.Test;

import java.util.Date;
import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest_Iteration2 {

    @Test
    public void Test_MeterReadingJob_DeadlineDate() {
        MeterReadingJob JOB = addJob();

        JOB.setDeadlineDate("20/02/2019");
        assertEquals("20/02/2019",JOB.getDeadlineDateString());
    }

    @Test
    public void Test_MeterReadingJob_Address() {
        MeterReadingJob JOB = addJob();

        JOB.setAddress("Address");
        assertEquals("Address",JOB.getJobAddress());
    }

    @Test
    public void Test_MeterReadingJob_MeterLocation() {
        MeterReadingJob JOB = addJob();

        JOB.setMeterLocation("Basement");
        assertEquals("Basement",JOB.getMeterLocation());
    }

    @Test
    public void Test_MeterReadingJob_UtilityCompany() {
        MeterReadingJob JOB = addJob();

        JOB.setUtilComp("Utility Company");
        assertEquals("Utility Company",JOB.getUtilityCompany());
    }

    @Test
    public void Test_MeterReadingJob_JobStatus() {
        MeterReadingJob JOB = addJob();

        JOB.setJobStatus(true);
        assertEquals(true,JOB.getJobStatus());
    }

    @Test
    public void Test_MeterReadingJob_CustomerName() {
        MeterReadingJob JOB = addJob();

        JOB.setCustomerName("Jake Morris");
        assertEquals("Jake Morris",JOB.getNameOfCustomer());
    }

    @Test
    public void Test_MeterReadingJob_MeterType() {
        MeterReadingJob JOB = addJob();

        JOB.setMeterType(0);
        assertEquals("Gas",JOB.getMeterTypeString());

        JOB.setMeterType(1);
        assertEquals("Electric",JOB.getMeterTypeString());

        JOB.setMeterType(2);
        assertEquals("Solar",JOB.getMeterTypeString());
    }

    @Test
    public void Test_MeterReadingJob_List_ReplaceJob() {
        MeterReadingJob JOB_1 = addJob();
        MeterReadingJob JOB_2 = addJob();

        MeterReadingJob_List.AddToList(JOB_1);
        assertEquals(JOB_1,MeterReadingJob_List.GetDisplayList().get(0));

        MeterReadingJob_List.ReplaceJob(JOB_2,JOB_1);

        assertEquals(JOB_2,MeterReadingJob_List.GetDisplayList().get(0));
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