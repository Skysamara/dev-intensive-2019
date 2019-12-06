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