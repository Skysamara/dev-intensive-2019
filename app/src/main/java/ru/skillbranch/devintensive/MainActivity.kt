package ru.skillbranch.devintensive

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.models.Bender

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var benderImage : ImageView
    lateinit var textTxt: TextView
    lateinit var messageEt: EditText
    lateinit var sendBtn: ImageView

    lateinit var benderObj: Bender

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        benderImage = iv_bender
        textTxt = tv_text
        messageEt = et_message
        sendBtn = iv_send

        val status = savedInstanceState?.getString("STATUS") ?:Bender.Status.NORMAL.name
        val question = savedInstanceState?.getString("QUESTION") ?:Bender.Question.NAME.name

        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question))

        Log.d("My_MainActivity.kt","onCreate $status $question")

        val (r,g,b) = benderObj.status.color
        benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)

        textTxt.text = benderObj.askQuestion()
        sendBtn.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        Log.d("My_MainActivity.kt","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("My_MainActivity.kt", "onResume")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("My_MainActivity.kt","onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("My_MainActivity.kt", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("My_MainActivity.kt", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("My_MainActivity.kt", "onDestroy")
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.d("My_MainActivity.kt", "onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putString("STATUS", benderObj.status.name)
        outState?.putString("QUESTION", benderObj.question.name)
        Log.d("My_MainActivity.kt","onSaveInstanceState ${benderObj.status.name} ${benderObj.question.name}")

    }

    override fun onClick(v: View?) {
        //TODO Ошибка при неправильно ответе
        //https://www.youtube.com/watch?v=cJaatOwP_WA&feature=youtu.be&t=6163
        if (v?.id == R.id.iv_send){
            val (phrase, color) = benderObj.listenAnswer(messageEt.text.toString())
            messageEt.setText("")
            val (r,g,b) = color
            benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
            textTxt.text = phrase
        }
    }


}
