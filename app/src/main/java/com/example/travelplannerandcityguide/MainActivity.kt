package com.example.travelplannerandcityguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.travelplannerandcityguide.ui.Home
import com.example.travelplannerandcityguide.ui.Login
import com.example.travelplannerandcityguide.ui.PlanningActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val home= Home()




        supportFragmentManager.beginTransaction().apply {
            replace(R.id.mainFragment,home)
            commit()
        }








        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId)
            {
              R.id.loginBtn->{
                  Intent(this,Login::class.java).also {
                      startActivity(it)
                  }
              }
                R.id.homeBtn->{
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.mainFragment,home)
                        commit()
                    }
                }
            }
            true
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}