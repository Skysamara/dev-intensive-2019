package ru.skillbranch.devintensive.models

class Bender(var status:Status = Status.NORMAL, var question: Question = Question.NAME) {

    fun askQuestion(): String = when(question){
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }

    fun listnAnswer(answer:String):Pair<String, Triple<Int, Int, Int>>{

        //TODO https://youtu.be/cJaatOwP_WA?t=6163

    }

    enum class Status(val color : Triple<Int, Int, Int>){
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICAL(Triple(255,255,0)),
    }

    enum class Question(val question: String, val answer:List<String>){
        NAME("Как меня зовут?", listOf("бендер", "bender")),
        PROFESSION("Назови мою профессию", listOf("сгибальщик", "bender")),
        MATERIAL("Из чго я сделан?", listOf("металл", "дерево","iron","wood","metal")),
        BDAY("Когда меня создали?", listOf("2993")),
        SERIAL("Мой серийный номе?", listOf("2716057")),
        IDLE("Наэтом всё, вопросов больше нет", listOf())
    }
}