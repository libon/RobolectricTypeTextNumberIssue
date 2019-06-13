package com.example.typetextnumber


import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleEspressoTest {
    @Test
    fun testEnterText() {
        launch(MainActivity::class.java)
        onView(withId(R.id.edittext)).perform(typeText("1234"))
        onView(withId(R.id.edittext)).check(matches(withText("1234")))
    }
}
