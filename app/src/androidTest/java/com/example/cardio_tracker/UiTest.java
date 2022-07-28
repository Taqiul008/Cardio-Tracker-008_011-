package com.example.cardio_tracker;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class perform UI test. Add ,Update and Delete operation in database performed
 */
@RunWith(AndroidJUnit4.class)
public class UiTest {

    @Rule
    public ActivityScenarioRule<recycler_Show> activityRule =
            new ActivityScenarioRule<>(recycler_Show.class);
    @Test
    public void testMain() {
        onView(withText("HISTORY")).check(matches(isDisplayed())); //Check the name on the screen
    }

    /**
     * Test floatbutton .Test Insert page.Test Insert page button
     */
    @Test
    public void insertItem()
    {
        onView(withId(R.id.floatbutton)).perform(click());
        onView(withId(R.id.systolic)).perform(ViewActions.typeText("120"),pressImeActionButton());
        onView(withId(R.id.dystolic)).perform(ViewActions.typeText("80"),pressImeActionButton());
        onView(withId(R.id.pulse)).perform(ViewActions.typeText("75"),pressImeActionButton());
        onView(withId(R.id.comment)).perform(ViewActions.typeText("Good"),pressImeActionButton());
        onView(withId(R.id.submit)).perform(click());
    }

    /**
     * Test update by clicking edit button in recyclerview card.
     */
    @Test
    public void EditItem()
    {
        onView(withId(R.id.update_list)).perform(click());
        onView(withId(R.id.systolic)).perform(ViewActions.clearText(),ViewActions.typeText("110"),pressImeActionButton());
        onView(withId(R.id.dystolic)).perform(ViewActions.clearText(),ViewActions.typeText("70"),pressImeActionButton());
        onView(withId(R.id.pulse)).perform(ViewActions.clearText(),ViewActions.typeText("65"),pressImeActionButton());
        onView(withId(R.id.comment)).perform(ViewActions.clearText(),ViewActions.typeText("bad"),pressImeActionButton());
        onView(withId(R.id.edit)).perform(click());
    }

    /**
     * Test delete button on card.Test Alert dialogue .
     */
    @Test
    public  void deleteItem()
    {
        onView(withId(R.id.delete_list)).perform(click());
        onView(withText("Yes")).perform(click());
    }
}
