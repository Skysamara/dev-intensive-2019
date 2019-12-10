package ru.skillbranch.devintensive.extensions

fun String.truncate(n:Int = 16):String{
//+TODO Реализуй extension усекающий исходную строку до указанного числа символов

//    Реализуй extension усекающий исходную строку до указанного числа символов (по умолчанию 16) и возвращающий усеченную строку с заполнителем "..." (если строка была усечена) если последний символ усеченной строки является пробелом - удалить его и добавить заполнитель
//    Пример:
//    "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate() //Bender Bending R...
//    "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15) //Bender Bending...
//    "A     ".truncate(3) //A

    if (this.trim().length >= n){
        return "${this.trim().take(n).trim()}..."
    }
    else{
        return this.trim()
    }
}

fun String.stripHtml(): String{
// TODO() Необходимо реализовать метод stripHtml для очистки строки от лишних пробелов

//    Необходимо реализовать метод stripHtml для очистки строки от лишних пробелов, html тегов, escape последовательностей
//    +1
//
//    Реализуй extension позволяющий очистить строку от html тегов и html escape последовательностей ("& < > ' ""), а так же удалить пустые символы (пробелы) между словами если их больше 1. Необходимо вернуть модифицированную строку
//    Пример:
//    "<p class="title">Образовательное IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch
//    "<p>Образовательное       IT-сообщество Skill Branch</p>".stripHtml() //Образовательное IT-сообщество Skill Branch

    return ""
}