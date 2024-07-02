package com.example.tripie.data.mock

import com.example.tripie.data.model.Trip

object MockBusData {
    private val busRoutes = listOf(
        Trip(
            from = "London",
            to = "New York",
            tripLengthInHours = 7,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "19:00",
            arrivalTime = "07:00"
        ),
        Trip(
            from = "Tokyo",
            to = "Los Angeles",
            tripLengthInHours = 10,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "13:30",
            arrivalTime = "17:30"
        ),
        Trip(
            from = "Dubai",
            to = "Sydney",
            tripLengthInHours = 14,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "21:00",
            arrivalTime = "05:00"
        ),
        Trip(
            from = "New York",
            to = "Paris",
            tripLengthInHours = 8,
            departureDate = "Jun 30",
            arrivalDate = "Jun 30",
            departureTime = "15:00",
            arrivalTime = "18:00"
        ),
        Trip(
            from = "Singapore",
            to = "Dubai",
            tripLengthInHours = 7,
            departureDate = "Jun 30",
            arrivalDate = "Jun 30",
            departureTime = "10:00",
            arrivalTime = "17:00"
        ),
        Trip(
            from = "Hong Kong",
            to = "San Francisco",
            tripLengthInHours = 14,
            departureDate = "Jun 30",
            arrivalDate = "Jul 02",
            departureTime = "23:00",
            arrivalTime = "06:00"
        ),
        Trip(
            from = "Manchester",
            to = "London",
            tripLengthInHours = 11,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "20:00",
            arrivalTime = "07:00"
        ),
        Trip(
            from = "São Paulo",
            to = "Toronto",
            tripLengthInHours = 10,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "22:00",
            arrivalTime = "08:00"
        ),
        Trip(
            from = "Buenos Aires",
            to = "Miami",
            tripLengthInHours = 9,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "23:30",
            arrivalTime = "08:30"
        ),
        Trip(
            to = "Frankfurt",
            from = "Beijing",
            tripLengthInHours = 10,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "13:00",
            arrivalTime = "07:00"
        )
    )

    val upcomingBusTrip = busRoutes[6]
}
