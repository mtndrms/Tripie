package com.example.tripie.data.mock.model

data class Hotel(
    val name: String,
    val country: String,
    val city: String,
    val pricePerNight: Int,
    val reviews: List<Review>,
) {
    val rating: Int
        get() = reviews.sumOf { it.rating } / reviews.size
}
