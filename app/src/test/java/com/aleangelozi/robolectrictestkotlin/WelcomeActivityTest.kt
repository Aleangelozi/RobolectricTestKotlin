package com.aleangelozi.robolectrictestkotlin

import android.content.Intent
import android.view.View
import com.aleangelozi.robolectrictestkotlin.ui.login.LoginActivity
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class WelcomeActivityTest {

    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        val activity : WelcomeActivity = Robolectric.setupActivity(WelcomeActivity::class.java)
        activity.findViewById<View>(R.id.login).performClick()

        val expectedIntent = Intent(activity, LoginActivity::class.java)
        val actual = shadowOf(RuntimeEnvironment.application).nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)

    }
}