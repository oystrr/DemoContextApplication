package com.example.democontextapplication

import android.widget.Button
import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.uiautomator.*
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class FirstUiAutomatorTest {
    private lateinit var device: UiDevice

    @Test
    fun clickOnNewTip() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        val allAppsButton: UiObject = device.findObject(
            UiSelector().description("DemoContextApplication"))

        allAppsButton.clickAndWaitForNewWindow()
        device.setOrientationLeft()
        getByTextAndClass("NEXT", Button::class.java.name)?.clickAndWaitForNewWindow()
        getByTextAndClass("Next", Button::class.java.name)?.clickAndWaitForNewWindow()
    }

    fun getByTextAndClass(text: String?, className: String?): UiObject? {
        return UiObject(UiSelector().text(text).className(className))
    }
}