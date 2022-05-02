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
    public void MeterReadingJob_Test_SettersAndGetters() {
        MeterReadingJob JOB = addJob();

        JOB.setMeterType(2);
        assertEquals("Solar",JOB.getMeterTypeString());

        JOB.setDeadlineDate("20/02/2019");
        assertEquals("20/02/2019",JOB.getDeadlineDateString());

        JOB.setAddress("Address");
        assertEquals("Address",JOB.getJobAddress());

        JOB.setMeterLocation("Basement");
        assertEquals("Basement",JOB.getMeterLocation());

        JOB.setUtilComp("Utility Company");
        assertEquals("Utility Company",JOB.getUtilityCompany());

        JOB.setJobStatus(true);
        assertEquals(true,JOB.getJobStatus());

        JOB.setCustomerName("Jake Morris");
        assertEquals("Jake Morris",JOB.getNameOfCustomer());
    }

    @Test
    public void ReplaceJobInMeterReadingList() {
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