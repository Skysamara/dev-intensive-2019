package ru.skillbranch.devintensive.util

object Utils {


    fun parceFullName(fullName:String?):Pair<String?, String?>{
//TODO + Проверить:
//        Пример:
//       + Utils.parseFullName(null) //null null
//       + Utils.parseFullName("") //null null
//       + Utils.parseFullName(" ") //null null
//       + Utils.parseFullName("John") //John null

        var fullNameTrim = fullName?.trim()
        fullNameTrim = if (fullNameTrim == "") null else fullNameTrim
        val parts : List<String>? = fullNameTrim?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

//        return Pair(firstName, lastName)
        return firstName to lastName    // Можно и так вернуть пару (Pair)
    }

    fun toInitials(firstName:String?, lastName:String?):String?{
//TODO +
//        Реализуй метод Utils.toInitials(firstName lastName) принимающий в качестве аргументов имя и фамилию пользователя (null, пустую строку) и возвращающий строку с первыми буквами имени и фамилии в верхнем регистре (если один из аргументов null то вернуть один инициал, если оба аргумента null вернуть null)
//        Пример:
//        Utils.toInitials("john" ,"doe") //JD
//        Utils.toInitials("John", null) //J
//        Utils.toInitials(null, null) //null
//        Utils.toInitials(" ", "") //null

        if (firstName == null && lastName == null){
            return null
        }

        if (firstName?.trim() == "" && firstName?.trim() == ""){
            return null
        }

        var fN = firstName?.capitalize()?.getOrNull(0)?:""
        var lN = lastName?.capitalize()?.getOrNull(0)?:""

        return "$fN$lN"
    }

    fun transliteration(payload:String, divider:String):String{
//TODO
//        Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
//        Пример:
//        Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
//        Utils.transliteration("Amazing Петр","_") //Amazing_Petr

        return  ""
    }
}
