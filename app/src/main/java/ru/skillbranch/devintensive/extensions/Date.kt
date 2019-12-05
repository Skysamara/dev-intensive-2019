@file:Suppress("UNREACHABLE_CODE")

package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"):String{
//+ TODO
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

fun Date.humanizeDiff():String {
//+TODO
//    Реализуй extension Date.humanizeDiff(date) (значение по умолчанию текущий момент времени) для форматирования вывода разницы между датами в человекообразном формате, с учетом склонения числительных. Временные интервалы преобразований к человекообразному формату доступны в ресурсах к заданию
//    Пример:
//    Date().add(-2, TimeUnits.HOUR).humanizeDiff() //2 часа назад
//    Date().add(-5, TimeUnits.DAY).humanizeDiff() //5 дней назад
//    Date().add(2, TimeUnits.MINUTE).humanizeDiff() //через 2 минуты
//    Date().add(7, TimeUnits.DAY).humanizeDiff() //через 7 дней
//    Date().add(-400, TimeUnits.DAY).humanizeDiff() //более года назад
//    Date().add(400, TimeUnits.DAY).humanizeDiff() //более чем через год

    val diff = abs(Date().time - this.time)
    var prefix = ""
    var postfix = ""
    if (Date().time < this.time) {
        prefix = "через"
    }
    else {
        postfix = "назад"
    }

    return when (diff) {
        in 0..SECOND -> "только что"                            // 0с - 1с "только что"
        in SECOND..45 * SECOND -> "несколько секунд назад"      // 1с - 45с "несколько секунд назад"
        in 45 * SECOND..75 * SECOND -> "минуту назад"           // 45с - 75с "минуту назад"
        in 75 * SECOND..45 * MINUTE -> {                        // 75с - 45мин "N минут назад"
            "$prefix ${numToWord(diff % (10 * MINUTE) / MINUTE, TimeUnits.MINUTE)} $postfix"
        }
        in 45 * MINUTE..75 * MINUTE -> "час назад"              // 45мин - 75мин "час назад"
        in 75 * MINUTE..22 * HOUR -> {                          // 75мин 22ч "N часов назад"
            "$prefix ${numToWord(diff % (10 * HOUR) / HOUR, TimeUnits.HOUR)} $postfix"
        }
        in 22 * HOUR..26 * HOUR -> "день назад"                 // 22ч - 26ч "день назад
        in 26 * HOUR..360 * HOUR -> {                           // 26ч - 360д "N дней назад"
            "$prefix ${numToWord(diff % (10 * DAY) / DAY, TimeUnits.DAY)} $postfix"
        }
            in 360*DAY..Long.MAX_VALUE -> {                     //  >360д "более года назад"
                if (Date().time < this.time){
                    "более чем через год"
                }
                else{
                    "более года назад"
                }
            }
            else -> "Ошибка $diff"
        }
    }

    fun numToWord(num: Long, timeUnit: TimeUnits): String {
        val n = num.toInt()
        return n.toString() + " " + when (timeUnit) {
            TimeUnits.MINUTE -> {
//                "MINUTE"
                when (n) {
                    0 -> "минут"
                    1 -> "минуту"
                    in 2..4 -> "минуты"
                    in 5..9 -> "минут"
                    else -> ""
                }
            }
            TimeUnits.HOUR -> {
//                "HOUR"
                when (n) {
                    0 -> "часов"
                    1 -> "час"
                    in 2..4 -> "часа"
                    in 5..9 -> "часов"
                    else -> ""
                }
            }
            TimeUnits.DAY -> {
//                "DAY"
                when (n) {
                    0 -> "дней"
                    1 -> "день"
                    in 2..4 -> "дня"
                    in 5..9 -> "дней"
                    else -> ""
                }
            }
            else -> ""
        }
    }








