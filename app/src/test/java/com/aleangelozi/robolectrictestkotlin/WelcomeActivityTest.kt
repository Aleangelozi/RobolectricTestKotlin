package com.aleangelozi.robolectrictestkotlin

import android.content.Intent
import android.view.View
import com.aleangelozi.robolectrictestkotlin.ui.login.LoginActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf

@RunWith(RobolectricTestRunner::class)
class WelcomeActivityTest {
    private lateinit var welcomeActivity: WelcomeActivity
    private lateinit var loginActivity: LoginActivity

    @Before
    fun setup() {
        welcomeActivity = Robolectric.setupActivity(WelcomeActivity::class.java)
        loginActivity = Robolectric.setupActivity(LoginActivity::class.java)
    }

    @Test @Throws(Exception::class)
    fun welcomeActivity_ShouldNotBeNull() {
        assertNotNull(welcomeActivity)
        welcomeActivity.finish()
    }

    @Test @Throws(Exception::class)
    fun loginActivity_shouldNotBeNull() {
        assertNotNull(loginActivity)
    }

    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        welcomeActivity.findViewById<View>(R.id.login).performClick()

        val expectedIntent = Intent(welcomeActivity, LoginActivity::class.java)
        val actual = shadowOf(RuntimeEnvironment.application).nextStartedActivity
        assertEquals(expectedIntent.component, actual.component)

    }
}