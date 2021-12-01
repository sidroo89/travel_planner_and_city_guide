package com.example.travelplannerandcityguide.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.travelplannerandcityguide.repository.LoginRepo

class LoginViewModelProvider(
        val loginRepo: LoginRepo
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(loginRepo) as T
    }
}