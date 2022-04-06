package com.example.ctstudents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ctstudents.databinding.ActivityBottom12Binding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Bottom1 : AppCompatActivity() {

    private lateinit var binding: ActivityBottom12Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottom12Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.bottom_nav_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        navView.setupWithNavController(navController)

    }
}