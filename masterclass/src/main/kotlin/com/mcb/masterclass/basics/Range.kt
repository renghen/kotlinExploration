package com.mcb.masterclass.basics

import java.text.SimpleDateFormat
import java.util.*

class DateIterator(start: Date, private val endInclusive: Date)
    : Iterator<Date> {

    private var current = start

    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): Date {
        return current++
    }
}

operator  fun Date.inc(): Date {
    TODO()
}

class DateRange(override val start: Date,
                override val endInclusive: Date)
    : ClosedRange<Date>, Iterable<Date> {


    override fun iterator(): Iterator<Date> {
        return DateIterator(start, endInclusive)
    }


}

fun dateRange(start : Date, end :Date) {
    val range = DateRange(start,end)
    for(d in range){
        println(d)
    }

}
operator fun Date.rangeTo(end: Date) = DateRange(this,end)



fun main() {
    val formatter = SimpleDateFormat("yyyy-MM-dd")

    val start = formatter.parse("2019-05-01")
    val end = formatter.parse("2019-05-31")
    val rangeDate1 = start..end

    val  someDate = formatter.parse("2019-05-06")

    val result2 = when(someDate){
        in rangeDate1 -> "correct date"
        else -> "wrong date"
    }

    for( someDay in rangeDate1){
        when(someDay.day){
            1 -> "right"
            else -> "wrong"
        }
    }

    println(result2)


    dateRange(start, end)
}

