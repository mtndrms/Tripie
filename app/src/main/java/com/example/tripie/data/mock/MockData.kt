package com.example.tripie.data.mock

import com.example.tripie.data.mock.model.Hotel
import com.example.tripie.data.mock.model.Review

object MockData {
    val hotel = Hotel(
        name = "Hotel Dark Diamond",
        country = "Switzerland",
        city = "Zurich",
        pricePerNight = 375,
        reviews = listOf(
            Review(
                name = "Test User",
                message = "Ut interdum, neque nec luctus consequat, ex quam efficitur est, et tempor sem magna sed velit.",
                rating = 4
            ),
            Review(
                name = "Test User 2",
                message = "Integer sollicitudin a lectus vel finibus.",
                rating = 2
            ),
            Review(
                name = "Test User 3",
                message = "Morbi ultrices leo sem, vel eleifend nunc porta sed.",
                rating = 1
            ),
            Review(
                name = "Test User 4",
                message = "In dignissim tellus a odio interdum condimentum.",
                rating = 5
            ),
            Review(
                name = "Test User 5",
                message = "Mauris nec ex enim. Morbi sed ex nec diam auctor imperdiet. Suspendisse ac sagittis erat.",
                rating = 5
            ),
        )
    )

    val mostPopularHotel = MostPopularHotel(hotel = hotel)
}