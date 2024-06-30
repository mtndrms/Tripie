package com.example.tripie.data.model

data class Flight(
    val departureCity: String,
    val departureCountry: String,
    val departureAirport: String,
    val arrivalCity: String,
    val arrivalCountry: String,
    val arrivalAirport: String,
    val flightTimeHours: Int,
    val departureDate: String,
    val arrivalDate: String,
    val departureTime: String,
    val arrivalTime: String
)