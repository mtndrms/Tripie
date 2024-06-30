package com.example.tripie.data.model

data class Trip(
    val from: String,
    val to: String,
    val tripLengthInHours: Int,
    val departureDate: String,
    val arrivalDate: String,
    val departureTime: String,
    val arrivalTime: String,
)
