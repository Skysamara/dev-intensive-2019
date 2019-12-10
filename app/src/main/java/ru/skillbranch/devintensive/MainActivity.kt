package ru.skillbranch.devintensive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("My_MainActivity.kt","onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("My_MainActivity.kt","onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("My_MainActivity.kt","onStart")
    }
}
