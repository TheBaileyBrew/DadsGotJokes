package com.udacity.gradle.builditbigger;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class OpenJokeDisplayActivityTest {

    public static final String EMPTY_STRING = "";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void clickGetJokeTest() {

        //Checks to verify that the button is clicked in MainActivity
        onView(withId(R.id.tell_me_a_joke)).perform(click());

        //Checks to verify that new view is loaded
        onView(withId(R.id.display_joke)).check(matches(not(withText(EMPTY_STRING))));

    }
}
