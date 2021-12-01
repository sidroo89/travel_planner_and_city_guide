package com.example.travelplannerandcityguide.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.travelplannerandcityguide.R

class PlanningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_planning)
    }
}