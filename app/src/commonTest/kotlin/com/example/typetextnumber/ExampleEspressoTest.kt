package com.example.typetextnumber


import android.view.View
import android.widget.EditText
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matcher
import org.hamcrest.core.AllOf.allOf
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleEspressoTest {
    @Test
    fun testEnterText() {
        launch(MainActivity::class.java)
        onView(withId(R.id.edittext)).perform(forceTypeText("1234"))
        onView(withId(R.id.edittext)).check(matches(withText("1234")))
    }
    // For an EditText with inputType="number", Espresso's typeText() doesn't have any impact
    // when run on robolectric.
    private fun forceTypeText(text: String): ViewAction {
        return object : ViewAction {
            override fun getDescription(): String {
                return "force type text"
            }

            override fun getConstraints(): Matcher<View> {
                return allOf(isEnabled())
            }

            override fun perform(uiController: UiController?, view: View?) {
                (view as? EditText)?.append(text)
                uiController?.loopMainThreadUntilIdle()
            }
        }
    }
}
