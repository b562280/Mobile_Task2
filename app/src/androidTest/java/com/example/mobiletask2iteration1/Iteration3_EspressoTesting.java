package com.example.mobiletask2iteration1;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.content.Intent;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.example.mobiletask2iteration1.Pages.HomePage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Iteration3_EspressoTesting {

    @Rule
    public ActivityTestRule<HomePage> activityRule = new ActivityTestRule<>(HomePage.class);

    @Test
    public void TestDateFilter() {
        addJobAndSetDate("02/04/2020", true);
        addJobAndSetDate("02/04/2019", false);
        addJobAndSetDate("02/04/2022", true);
        addJobAndSetDate("02/04/2021", true);
        activityRule.launchActivity(new Intent());
        onView(withId(R.id.SearchFAB))
                .perform(click());
        onView(withId(R.id.SearchLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.button_SearchDeadlineDate)).perform(click());
    }

    @Test
    public void TestStatusFilter() {
        onView(withId(R.id.SearchFAB))
                .perform(click());
        onView(withId(R.id.SearchLayout)).check(matches(isDisplayed()));
        onView(withId(R.id.button_SearchJobStat)).perform(click());
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