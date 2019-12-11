package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
//+ Необходимо реализовать Builder для класса User

//    Реализуй паттерн Builder для класса User.
//    User.Builder().id(s)
//    .firstName(s)
//    .lastName(s)
//    .avatar(s)
//    .rating(n)
//    .respect(n)
//    .lastVisit(d)
//    .isOnline(b)
//    .build() должен вернуть объект User

    var id:String = "",
    var firstName:String = "",
    var lastName:String = "",
    var avatar:String = "",
    var rating:Int = 0,
    var respect:Int = 0,
    var lastVisit: Date = Date(),
    var isOnline:Boolean = false
){

//    constructor(id: String, firstName: String, lastName: String):this(
//        id = id,    // можноуказать конкретное соответствие параметров
//        firstName = firstName,
//        lastName = lastName,
//        avatar = null
//    )
//    constructor(id: String) : this(id, "John", "Doe $id") // а можно просто по-порядку
//
//    init {
//        println("Alive!")
//    }

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

//    companion object Factory{
//        private var lastId : Int = -1
//        fun makeUser(fullname:String) : User{
//            lastId++
//
//            val (firstName, lastName) = Utils.parseFullName(fullname)
//            return User(id = "$lastId", firstName = firstName, lastName = lastName)
//
//        }
//    }


    class Builder(){
//        private var user:User = User(id = id, firstName = "Ivan", lastName = "Ivanov")
        private var user:User = User()

        fun  id(id: String): Builder{
            this.user.id = id
            return this
        }
        fun  firstName(firstName: String): Builder{
            this.user.firstName = firstName
            return this
        }
        fun  lastName(lastName: String): Builder{
            this.user.lastName = lastName
            return this
        }
        fun  avatar(avatar: String): Builder{
            this.user.avatar = avatar
            return this
        }
        fun  rating(rating: Int): Builder{
            this.user.rating = rating
            return this
        }
        fun  respect(respect: Int): Builder{
            this.user.respect = respect
            return this
        }
        fun  lastVisit(lastVisit: Date): Builder{
            this.user.lastVisit = lastVisit
            return this
        }
        fun  isOnline(isOnline: Boolean): Builder{
            this.user.isOnline = isOnline
            return this
        }


        fun build(): User{
            return user
        }
    }
}

