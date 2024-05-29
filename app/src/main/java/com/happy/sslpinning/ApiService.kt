package com.happy.sslpinning

import com.happy.maxyard.gson.login.LoginJson
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @Headers("Content-Type:application/json")
    @POST("YardValidateLogin")
    fun registerUser(
        @Body info: LoginInputModel
    ): Call<LoginJson>

}