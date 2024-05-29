package com.happy.maxyard.gson.login

data class LoginResponseStatu(
    val address: String,
    val agreementDate: String,
    val contactNumber: String,
    val idYardMaster: Int,
    val landMark: String,
    val name: String,
    val pin: String,
    val status: Int,
    val statusMessage: String,
    val loginID: String,
    val version: String
)