package com.happy.maxyard.gson.login

data class Data(
    val exceptionData: Any,
    val loginResponseStatus: List<LoginResponseStatu>,
    val token: String
)