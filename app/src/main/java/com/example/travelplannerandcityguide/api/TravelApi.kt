package com.example.travelplannerandcityguide.api


import com.example.travelplannerandcityguide.model.Profile
import com.example.travelplannerandcityguide.model.TokenResponce

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TravelApi {

    @POST("auth/register")
   suspend fun postProfile(@Body params: Profile):Response<TokenResponce>


}