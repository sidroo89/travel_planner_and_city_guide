package com.example.travelplannerandcityguide.repository

import com.example.travelplannerandcityguide.api.RetroInstance
import com.example.travelplannerandcityguide.model.Profile

class LoginRepo {
suspend fun postProfileRegister(profile: Profile)=
        RetroInstance.api.postProfile(profile)
}