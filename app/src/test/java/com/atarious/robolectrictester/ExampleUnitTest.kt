package com.atarious.robolectrictester

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(manifest= Config.NONE)
class ExampleUnitTest {
    @Test
    fun check_main_activity_text() {
        val activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
        val textView : TextView = activity.findViewById<TextView>(R.id.activity_textView)
        assertEquals("ActivityTextView", textView.text.toString())

    }

    @Test
    fun check_first_fragment_text(){
        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(R.id.textview_first)
        assertEquals("TestCompleted", textView.text)
    }

}