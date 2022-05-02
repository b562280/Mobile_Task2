package com.example.mobiletask2iteration1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest_Iteration3 {

    @Test
    public void TestFilterByJobStatus() {
        addJobAndSetDate("02/04/2020", true);
        addJobAndSetDate("02/04/2019", false);
        addJobAndSetDate("02/04/2022", true);
        addJobAndSetDate("02/04/2021", true);

        MeterReadingJob_List.SortByJobCompleted();

        assertEquals(false,
                MeterReadingJob_List.GetDisplayList().get(0).getJobStatus());
        assertEquals(true,
                MeterReadingJob_List.GetDisplayList().get(1).getJobStatus());
        assertEquals(true,
                MeterReadingJob_List.GetDisplayList().get(2).getJobStatus());
        assertEquals(true,
                MeterReadingJob_List.GetDisplayList().get(3).getJobStatus());

        MeterReadingJob_List.GetDisplayList().clear();
    }

    @Test
    public void TestFilterByDate() {
        addJobAndSetDate("02/04/2020", true);
        addJobAndSetDate("02/04/2019", false);
        addJobAndSetDate("02/04/2022", true);
        addJobAndSetDate("02/04/2021", true);

        MeterReadingJob_List.SortByDate();

        assertEquals("02/04/2022",
                MeterReadingJob_List.GetDisplayList().get(0).getDeadlineDateString());
        assertEquals("02/04/2021",
                MeterReadingJob_List.GetDisplayList().get(1).getDeadlineDateString());
        assertEquals("02/04/2020",
                MeterReadingJob_List.GetDisplayList().get(2).getDeadlineDateString());
        assertEquals("02/04/2019",
                MeterReadingJob_List.GetDisplayList().get(3).getDeadlineDateString());
        MeterReadingJob_List.GetDisplayList().clear();
    }

    private void addJobAndSetDate (String Date, Boolean Status) {
        Random random = new Random();
        Date inputDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        try {
            inputDate = ft.parse(Date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MeterReadingJob_List.AddToList(new MeterReadingJob(
                random.nextInt(99999),
                0,
                inputDate,
                "jobAddress",
                "meterLocation",
                "utilityCompany",
                Status,
                "nameOfCustomer")
        );
    }
}