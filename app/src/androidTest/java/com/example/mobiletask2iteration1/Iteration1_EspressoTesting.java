package com.example.mobiletask2iteration1;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import com.example.mobiletask2iteration1.Pages.HomePage;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class Iteration1_EspressoTesting {

    @Rule
    public ActivityScenarioRule<HomePage> activityRule = new ActivityScenarioRule<>(HomePage.class);

    @Test
    public void TestAddJob() {
        onView(withId(R.id.addJob)).perform(click());
        onView(withId(R.id.recyclerView)).check(matches(hasDescendant(
                isDisplayed())));
    }

    @Test
    public void RemoveJob() {
        onView(withId(R.id.imageButton_Remove)).perform(click());
        onView(withId(R.id.recyclerView)).check(matches(not(hasDescendant(
                isDisplayed()))));

    }

    @Test
    public void ViewJob() {
        onView(withId(R.id.addJob)).perform(click());
        onView(withId(R.id.imageButton_Edit)).perform(click());
        onView(withId(R.id.ViewJobLayout)).check(matches(isDisplayed()));

    }
}