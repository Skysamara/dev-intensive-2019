package ru.skillbranch.devintensive

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("My_MainActivity.kt","onCreate")
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

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("My_MainActivity.kt", "onSaveInstanceState")
    }



}
