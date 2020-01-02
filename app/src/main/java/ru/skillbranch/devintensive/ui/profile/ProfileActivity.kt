package ru.skillbranch.devintensive.ui.profile

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_profile.*
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.models.Bender

class ProfileActivity : AppCompatActivity() {

    companion object{
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }

    var isEditMode = false
    lateinit var viewFields : Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("My_", "onCreate")
        setContentView(R.layout.activity_profile)
        initViews(savedInstanceState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("My_", "onSaveInstanceState")

//        outState?.putBoolean(IS_EDIT_MODE, isEditMode)
        // Сохранение режима редактирования работает и без этого. Почему?
        // https://youtu.be/I6cmLJhvR9o?t=5703
    }

    override fun onResume() {
        Log.d("My_", "onResume")
        super.onResume()
    }

    private fun initViews(savedInstanceState: Bundle?) {
        Log.d("My_", "initViews")
        viewFields = mapOf(
            "nicname" to tv_nick_name,
            "rank" to tv_rank,
            "firstName" to et_first_name,
            "lastName" to et_last_name,
            "about" to et_about,
            "repository" to et_repository,
            "rating" to tv_rating,
            "respect" to tv_respecr
        )

        isEditMode = savedInstanceState?.getBoolean(IS_EDIT_MODE, false) ?:false
        // Сохранение режима редактирования работает и без этого. Почему?
        // https://youtu.be/I6cmLJhvR9o?t=5703

        showCurrentMode(isEditMode)

//        btn_edit.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                isEditMode = !isEditMode
//                showCurrentMode(isEditMode)
//            }
//        })

        btn_edit.setOnClickListener {
            isEditMode = !isEditMode
            showCurrentMode(isEditMode)
        }

//        btn_edit.setOnClickListener({
//            isEditMode = !isEditMode
//            showCurrentMode(isEditMode)
//        })
    }

    private fun showCurrentMode(editMode: Boolean) {
        val info = viewFields.filter { setOf("firstName", "lastName", "about", "repository").contains(it.key) }
//        for (i in info){
//            i.value as EditText
//            i.value.isFocusable = editMode

        for ((_, v) in info){
            v as EditText
//            v.isFocusable = editMode
//            v.isFocusableInTouchMode = editMode
//            v.isEnabled = editMode
//            v.background.alpha = if(editMode) 255 else 0

            with(v){
//            https://youtu.be/I6cmLJhvR9o?t=5348
                isFocusable = editMode
                isFocusableInTouchMode = editMode
                isEnabled = editMode
                background.alpha = if(editMode) 255 else 0
            }


        }

        ic_eye.visibility = if (editMode) View.GONE else View.VISIBLE
        wr_about.isCounterEnabled = editMode    // Подсвечивание количества
        //введенных символов

        with(btn_edit) {
            val filter: ColorFilter? = if (isEditMode){
                PorterDuffColorFilter(
                    resources.getColor(R.color.color_accent, theme),
                    PorterDuff.Mode.SRC_IN
                )
        }
            else{
                null
            }

            val icon = if (isEditMode){
                resources.getDrawable(R.drawable.ic_save_black_24dp)
            }
            else{
                resources.getDrawable(R.drawable.ic_edit_black_24dp)
            }

            background.colorFilter = filter
            setImageDrawable(icon)
        }

    }
}

