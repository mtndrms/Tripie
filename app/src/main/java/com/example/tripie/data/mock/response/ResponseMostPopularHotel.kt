package com.example.tripie.data.mock.response

import com.example.tripie.common.Month
import com.example.tripie.data.model.Hotel

data class ResponseMostPopularHotel(
    val hotel: Hotel,
) {
    val nights: Int = (1..14).random()

    private val startMonth = Month.entries.random()
    private var endMonth = startMonth
    private val start = (1..startMonth.days).random()
    private val end =
        if (start + nights < startMonth.days) {
            start + nights
        } else {
            endMonth = if (startMonth.order == 12) {
                Month.JANUARY
            } else {
                Month.entries[startMonth.order]
            }

            start + nights - startMonth.days
        }


    val startDate = "${startMonth.abbreviation} $start"
    val endDate = "${endMonth.abbreviation} $end"
}
