package com.happy.sslpinning

import com.google.gson.annotations.SerializedName

data class LoginInputModel (
    @SerializedName("loginId") val userName: String?,
    @SerializedName("password") val password: String?,
    @SerializedName("mobileLogin") val mobileLogin: Int?,
    @SerializedName("version") val version: String?,
)