package com.example.democontextapplication

import android.content.Intent
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf


@RunWith(RobolectricTestRunner::class)

class FirstRobolectricTest {
    private lateinit var activity: MainActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun shouldNotBeNull() {
        assertNotNull(activity)
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun clickingButton1_shouldStartNextActivity() {
        Robolectric.buildActivity(MainActivity::class.java).use { controller ->
            controller.setup() // Moves Activity to RESUMED state
            val activity: MainActivity = controller.get()
            val button = activity.bNext
            button.performClick()
            val expectedIntent = Intent(activity, NextActivity::class.java)
            val actual: Intent = shadowOf(RuntimeEnvironment.application).getNextStartedActivity()
            assertEquals(expectedIntent.component, actual.component)
        }
    }

}