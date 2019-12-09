package ru.skillbranch.devintensive.utils

object Utils {

    fun parseFullName(fullName:String?):Pair<String?, String?>{
//+TODO parseFullName

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
//+TODO Реализуй метод Utils.toInitials(firstName lastName)

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

    fun transliteration(payload:String, divider:String = " "):String?{
//+TODO Реализуй метод Utils.transliteration(payload divider)

//        Реализуй метод Utils.transliteration(payload divider) принимающий в качестве аргумента строку (divider по умолчанию " ") и возвращающий преобразованную строку из латинских символов, словарь символов соответствия алфовитов доступен в ресурсах к заданию
//        Пример:
//        Utils.transliteration("Женя Стереотипов") //Zhenya Stereotipov
//        Utils.transliteration("Amazing Петр","_") //Amazing_Petr

        var map:MutableMap<String, String> = mutableMapOf()
        var mapUp:MutableMap<String, String> = mutableMapOf()
        var result:String = ""

        map.put("а", "a")
        map.put("б", "b")
        map.put("в", "v")
        map.put("г", "g")
        map.put("д", "d")
        map.put("е", "e")
        map.put("ё", "e")
        map.put("ж", "zh")
        map.put("з", "z")
        map.put("и", "i")
        map.put("й", "i")
        map.put("к", "k")
        map.put("л", "l")
        map.put("м", "m")
        map.put("н", "n")
        map.put("о", "o")
        map.put("п", "p")
        map.put("р", "r")
        map.put("с", "s")
        map.put("т", "t")
        map.put("у", "u")
        map.put("ф", "f")
        map.put("х", "h")
        map.put("ц", "c")
        map.put("ч", "ch")
        map.put("ш", "sh")
        map.put("щ", "sh'")
        map.put("ъ", "")
        map.put("ы", "i")
        map.put("ь", "")
        map.put("э", "e")
        map.put("ю", "yu")
        map.put("я", "ya")

        for (n in map){
            mapUp.put(n.key.capitalize(), n.value.capitalize())
        }
        map.putAll(mapUp)
        map.put(" ", divider)

        for (s in payload){
            result = result.plus(map[s.toString()]?:s.toString())
        }

        return result
    }

}
