package com.example.tripie.data.mock.response

import com.example.tripie.data.model.Flight

data class ResponseBestDeal(
    val flight: Flight,
    val airline: String,
    val price: Int
)
