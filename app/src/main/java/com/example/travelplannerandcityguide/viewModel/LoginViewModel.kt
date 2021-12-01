package com.example.travelplannerandcityguide.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelplannerandcityguide.api.RetroInstance
import com.example.travelplannerandcityguide.api.TravelApi
import com.example.travelplannerandcityguide.model.Profile
import com.example.travelplannerandcityguide.model.TokenResponce
import com.example.travelplannerandcityguide.repository.LoginRepo
import com.example.travelplannerandcityguide.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(
        val loginRepository: LoginRepo
): ViewModel() {
val tokenResponse: MutableLiveData<Resource<TokenResponce>> = MutableLiveData()
    init {

    }
    fun postProfile(profile:Profile)=viewModelScope.launch {
        tokenResponse.postValue(Resource.Loading())
        val response=loginRepository.postProfileRegister(profile)
        Log.d("testing","resonse got")
        tokenResponse.postValue(handleProfileRegister(response))


    }
    private fun handleProfileRegister(response:Response<TokenResponce>):Resource<TokenResponce>
    {
        if(response.isSuccessful)
        {
            response.body()?.let { resultResponse->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}