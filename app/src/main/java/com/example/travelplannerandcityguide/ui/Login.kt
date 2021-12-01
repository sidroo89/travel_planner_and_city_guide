package com.example.travelplannerandcityguide.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.travelplannerandcityguide.R
import com.example.travelplannerandcityguide.repository.LoginRepo
import com.example.travelplannerandcityguide.ui.fragments.LoginPage
import com.example.travelplannerandcityguide.viewModel.LoginViewModel
import com.example.travelplannerandcityguide.viewModel.LoginViewModelProvider
import kotlinx.android.synthetic.main.login_page.*


class Login :  AppCompatActivity(){

lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        val loginRepo=LoginRepo()

        val viewModeProviderFactory=LoginViewModelProvider(loginRepo)

        viewModel=ViewModelProvider(this,viewModeProviderFactory).get(LoginViewModel::class.java)



    }
}