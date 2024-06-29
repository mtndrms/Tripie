package com.example.tripie.common

import com.example.tripie.util.DateUtil
import java.util.Calendar

enum class Month(val order: Int, val abbreviation: String, val days: Int) {
    JANUARY(1, "Jan", 31),
    FEBRUARY(
        2,
        "Feb",
        if (DateUtil.isLeapYear(Calendar.getInstance().get(Calendar.YEAR))) 29 else 28
    ),
    MARCH(3, "Mar", 31),
    APRIL(4, "Apr", 30),
    MAY(5, "May", 31),
    JUNE(6, "Jun", 30),
    JULY(7, "Jul", 31),
    AUGUST(8, "Aug", 31),
    SEPTEMBER(9, "Sep", 30),
    OCTOBER(10, "Oct", 31),
    NOVEMBER(11, "Nov", 30),
    DECEMBER(12, "Dec", 31);
}
