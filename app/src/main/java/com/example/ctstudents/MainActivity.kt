package com.example.ctstudents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    //    private val HomeFragment = HomeFragment()
//    private val FeedFragment = FeedFragment()
//    private val ReminderFragment = ReminderFragment()
//    private val ProfileFragment = ProfileFragment()
//    lateinit var bottomNav: NavigationBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Fragment_Home -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.Fragment_Feed -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.Fragment_Reminder -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.Fragment_Profile -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }

    }
}
