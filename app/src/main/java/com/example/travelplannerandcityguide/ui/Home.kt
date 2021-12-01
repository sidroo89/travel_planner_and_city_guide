package com.example.travelplannerandcityguide.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelplannerandcityguide.R
import kotlinx.android.synthetic.main.home_appbar_layouts.*


class Home : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startPlannerBtn.setOnClickListener {
            Intent(context, PlanningActivity::class.java).also {
                startActivity(it)
            }
        }
    }


}