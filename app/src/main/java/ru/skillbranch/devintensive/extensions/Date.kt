package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
//TODO. + Проверить
//        Реализуй extension Date.format(pattern) возвращающий отформатированную
//        дату по паттерну передаваемому в качестве аргумента (
//        значение по умолчанию "HH:mm:ss dd.MM.yy" локаль "ru")
//        Пример:
//        Date().format() //14:00:00 27.06.19
//        Date().format("HH:mm") //14:00

    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND):Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return  this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

fun Date.humanizeDiff():String{
    val diff = Date().time - this.time

    return when(diff){
        in 0..SECOND -> "только что"                        // 0с - 1с "только что"
        in SECOND..45*SECOND -> "несколько секунд назад"    // 1с - 45с "несколько секунд назад"
        in 45*SECOND..75*SECOND -> "минуту назад"           // 45с - 75с "минуту назад"
        in 75*SECOND..45*MINUTE -> "N минут назад"          // 75с - 45мин "N минут назад"
        in 45*MINUTE..75*MINUTE -> "час назад"              // 45мин - 75мин "час назад"
        in 75*MINUTE..22*HOUR ->  "N часов назад"           // 75мин 22ч "N часов назад"
        in 22*HOUR..26*HOUR -> "день назад"                 // 22ч - 26ч "день назад
        in 26*HOUR..360*HOUR -> "N дней назад"              // 26ч - 360д "N дней назад"
        in 360*DAY..Long.MAX_VALUE -> "более года назад"    //  >360д "более года назад"
        else -> "Ошибка"
    }

}