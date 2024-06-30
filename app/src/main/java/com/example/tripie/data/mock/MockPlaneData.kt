package com.example.tripie.data.mock

import com.example.tripie.data.mock.response.ResponseBestDeal
import com.example.tripie.data.model.Flight

object MockPlaneData {
    private val flightRoutes = listOf(
        Flight(
            departureCity = "New York",
            departureCountry = "USA",
            departureAirport = "JFK",
            arrivalCity = "London",
            arrivalCountry = "UK",
            arrivalAirport = "Heathrow",
            flightTimeHours = 7,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "19:00",
            arrivalTime = "07:00"
        ),
        Flight(
            departureCity = "Los Angeles",
            departureCountry = "USA",
            departureAirport = "LAX",
            arrivalCity = "Tokyo",
            arrivalCountry = "Japan",
            arrivalAirport = "Haneda",
            flightTimeHours = 11,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "13:30",
            arrivalTime = "17:30"
        ),
        Flight(
            departureCity = "Sydney",
            departureCountry = "Australia",
            departureAirport = "Kingsford Smith",
            arrivalCity = "Dubai",
            arrivalCountry = "UAE",
            arrivalAirport = "DXB",
            flightTimeHours = 14,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "21:00",
            arrivalTime = "05:00"
        ),
        Flight(
            departureCity = "Paris",
            departureCountry = "France",
            departureAirport = "Charles de Gaulle",
            arrivalCity = "New York",
            arrivalCountry = "USA",
            arrivalAirport = "JFK",
            flightTimeHours = 8,
            departureDate = "Jun 30",
            arrivalDate = "Jun 30",
            departureTime = "15:00",
            arrivalTime = "18:00"
        ),
        Flight(
            departureCity = "Dubai",
            departureCountry = "UAE",
            departureAirport = "DXB",
            arrivalCity = "Singapore",
            arrivalCountry = "Singapore",
            arrivalAirport = "Changi",
            flightTimeHours = 7,
            departureDate = "Jun 30",
            arrivalDate = "Jun 30",
            departureTime = "10:00",
            arrivalTime = "17:00"
        ),
        Flight(
            departureCity = "San Francisco",
            departureCountry = "USA",
            departureAirport = "SFO",
            arrivalCity = "Hong Kong",
            arrivalCountry = "China",
            arrivalAirport = "HKG",
            flightTimeHours = 14,
            departureDate = "Jun 30",
            arrivalDate = "Jul 02",
            departureTime = "23:00",
            arrivalTime = "06:00"
        ),
        Flight(
            departureCity = "London",
            departureCountry = "UK",
            departureAirport = "Heathrow",
            arrivalCity = "Johannesburg",
            arrivalCountry = "South Africa",
            arrivalAirport = "O.R. Tambo",
            flightTimeHours = 11,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "20:00",
            arrivalTime = "07:00"
        ),
        Flight(
            departureCity = "Toronto",
            departureCountry = "Canada",
            departureAirport = "Pearson",
            arrivalCity = "São Paulo",
            arrivalCountry = "Brazil",
            arrivalAirport = "Guarulhos",
            flightTimeHours = 10,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "22:00",
            arrivalTime = "08:00"
        ),
        Flight(
            departureCity = "Miami",
            departureCountry = "USA",
            departureAirport = "MIA",
            arrivalCity = "Buenos Aires",
            arrivalCountry = "Argentina",
            arrivalAirport = "Ezeiza",
            flightTimeHours = 9,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "23:30",
            arrivalTime = "08:30"
        ),
        Flight(
            departureCity = "Frankfurt",
            departureCountry = "Germany",
            departureAirport = "FRA",
            arrivalCity = "Beijing",
            arrivalCountry = "China",
            arrivalAirport = "Capital",
            flightTimeHours = 10,
            departureDate = "Jun 30",
            arrivalDate = "Jul 01",
            departureTime = "13:00",
            arrivalTime = "07:00"
        )
    )

    private val airlines = listOf(
        "Singapore Airlines",
        "Qatar Airways",
        "ANA All Nippon Airways",
        "Emirates",
        "Japan Airlines (JAL)",
        "Cathay Pacific",
        "Lufthansa",
        "Turkish Airlines",
        "Korean Air",
        "Air New Zealand"
    )

    val upcomingFlight = flightRoutes.first()
    val bestDeal = ResponseBestDeal(
        flight = flightRoutes.last(),
        airline = airlines.random(),
        price = (50..500).random()
    )
}