package com.devstoriesafrica.devstoriesafrica.models.requests

data class VerifyOtp(
    val email: String,
    val otp: String
)