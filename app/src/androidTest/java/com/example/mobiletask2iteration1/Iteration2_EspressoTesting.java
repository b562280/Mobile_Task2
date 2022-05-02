package com.example.mobiletask2iteration1;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.hasTextColor;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withResourceName;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.test.espresso.matcher.BoundedMatcher;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.example.mobiletask2iteration1.Pages.HomePage;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Iteration2_EspressoTesting {

    @Rule
    public ActivityTestRule<HomePage> activityRule = new ActivityTestRule<>(HomePage.class);

    @Test
    public void TestEditJob() {
        onView(withId(R.id.addJob)).perform(click());
        onView(withId(R.id.JobType)).check(matches(withText("Job Type: Gas")));
        onView(withId(R.id.imageButton_Edit)).perform(click());
        onView(withId(R.id.viewJob_MeterType)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.floatingActionButton_Save)).perform(click());
        onView(withId(R.id.JobType)).check(matches(withText("Job Type: Electric")));
        onView(withId(R.id.imageButton_Remove)).perform(click());
    }

    @Test
    public void TestSaveAndLoad() {
        onView(withId(R.id.addJob)).perform(click());
        activityRule.finishActivity();
        activityRule.launchActivity(new Intent());
        onView(withId(R.id.syncList)).perform(click());
        onView(withId(R.id.recyclerView)).check(matches(hasDescendant(
                isDisplayed())));
        onView(withId(R.id.imageButton_Remove)).perform(click());
    }

}