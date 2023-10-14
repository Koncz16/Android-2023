package main

import java.time.LocalDate

data class Date(
    val year: Int = LocalDate.now().year,
    val month: Int = LocalDate.now().monthValue,
    val day: Int = LocalDate.now().dayOfMonth
):Comparable<Date> {

    override fun compareTo(other: Date): Int {
        if (this.year != other.year) {
            return this.year - other.year
        }
        if (this.month != other.month) {
            return this.month - other.month
        }
        return this.day - other.day
    }

    fun Date.isLeapYear(year: Int): Boolean {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    }
}
    fun Date.isValidDate(): Boolean {
        return try {
            LocalDate.of(year, month, day)
            true
        } catch (ex: Exception) {
            false
        }
    }
