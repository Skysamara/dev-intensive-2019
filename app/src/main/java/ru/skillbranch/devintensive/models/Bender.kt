package ru.skillbranch.devintensive.models

import android.util.Log

class Bender(var status:Status = Status.NORMAL, var question: Question = Question.NAME) {

    fun askQuestion(): String = when(question){
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }

    fun listenAnswer(answer:String):Pair<String, Triple<Int, Int, Int>>{

        if (question == Question.IDLE){
            Log.d("My_Bender.kt","$status ${status.color}")
            return "Отлично - ты справился\nНа этом все, вопросов больше нет" to status.color
        }

        if(status == Status.CRITICAL){
            status = Status.NORMAL
            question = Question.NAME
            Log.d("My_Bender.kt","$status ${status.color}")
            return "Это неправильный ответ. Давай все по новой\n${question.question}" to status.color
        }

//        if (question.isAnswerCorrect(answer)){
//            question = question.nextQuetion()
//            Log.d("My_Bender.kt","$status ${status.color}")
//            return "Отлично - ты справился\n${question.question}" to status.color
//        } else
//        {
//            status = status.nextStatus()
//            Log.d("My_Bender.kt","$status ${status.color}")
//            return "Это неправильный ответ!\n${question.question}" to status.color
//        }
        return if (question.answer.contains(answer)){
            question = question.nextQuetion()
            "Отлично - ты справился\n${question.question}" to status.color
        } else{
            status = status.nextStatus()
            question.nextQuetion()
            "Это неправильный ответ\n${question.question}" to status.color
        }
    }

    enum class Status(val color : Triple<Int, Int, Int>){
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICAL(Triple(255,255,0));

        fun nextStatus(): Status{
            return  if (this.ordinal < values().lastIndex){
                values()[this.ordinal + 1]
            }
            else{
                values()[0]
            }
        }
    }

    enum class Question(val question: String, val answer:List<String>){
        //TODO Переделать с учетом задания

        NAME("Как меня зовут?", listOf("Бендер", "bender", "бендер", "Bender")) {
//        Question.NAME -> "Имя должно начинаться с заглавной буквы"
            override fun nextQuetion(): Question = PROFESSION
            override fun isAnswerCorrect(answer: String): Boolean {
                return answer.firstOrNull()?.isUpperCase() ?: false
            }
        },
        PROFESSION("Назови мою профессию?", listOf("сгибальщик", "bender")) {
//        Question.PROFESSION -> "Профессия должна начинаться со строчной буквы"
            override fun nextQuetion(): Question = MATERIAL
            override fun isAnswerCorrect(answer: String): Boolean {
                return answer.firstOrNull()?.isLowerCase() ?: false
            }
        },
        MATERIAL("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron", "wood")) {
//        Question.MATERIAL -> "Материал не должен содержать цифр"
            override fun nextQuetion(): Question = BDAY
            override fun isAnswerCorrect(answer: String): Boolean {
                return answer.trim().contains(Regex("\\d")).not()
            }
        },
        BDAY("Когда меня создали?", listOf("2993")) {
//        Question.BDAY -> "Год моего рождения должен содержать только цифры"
            override fun nextQuetion(): Question = SERIAL
            override fun isAnswerCorrect(answer: String): Boolean {
                return answer.contains(Regex("^[0-9]*$"))
            }
        },
        SERIAL("Мой серийный номер?", listOf("2716057")) {
//        Question.SERIAL -> "Серийный номер содержит только цифры, и их 7"
            override fun nextQuetion(): Question = IDLE
            override fun isAnswerCorrect(answer: String): Boolean {
                return answer.trim().contains(Regex("^[0-9]{7}$"))
            }
        },
        IDLE("На этом все, вопросов больше нет", listOf()) {
//        Question.IDLE -> //игнорировать валидацию
            override fun nextQuetion(): Question = IDLE
            override fun isAnswerCorrect(answer: String): Boolean {
                return true
            }
        };

        abstract fun nextQuetion():Question
        abstract fun isAnswerCorrect(answer: String):Boolean
    }
}