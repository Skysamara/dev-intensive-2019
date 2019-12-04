package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.util.Utils
import java.util.*

class User (
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int = 0,
    var respect:Int = 0,
    val lastVisit: Date? = Date(),
    val isOnline:Boolean = false
){
    constructor(id: String, firstName: String?, lastName: String?):this(
        id = id,    // можноуказать конкретное соответствие параметров
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String) : this(id, "John", "Doe $id") // а можно просто по-порядку

    init {
        println("Alive!")
    }

    fun printMe():Unit{
        println("""
            id:$id
            firstName:$firstName
            lastName:$lastName
            avatar:$avatar
            rating:$rating
            respect:$respect
            lastVisit:$lastVisit: 
            isOnline:$isOnline
        """.trimIndent())
    }

    companion object Factory{
        private var lastId : Int = -1
        fun makeUser(fullname:String) : User{
            lastId++

            val (firstName, lastName) = Utils.parceFullName(fullname)
            return User(id = "$lastId", firstName = firstName, lastName = lastName)

        }
    }
}

