package com.example.qa_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Tag : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tag)
        val btn =
            findViewById<View>(R.id.button) as Button
        val btn1 =
            findViewById<View>(R.id.button1) as Button
        val btn2 =
            findViewById<View>(R.id.button2) as Button
        val btn3 =
            findViewById<View>(R.id.button3) as Button
        val btn4 =
            findViewById<View>(R.id.button4) as Button
        val btn5 =
            findViewById<View>(R.id.button5) as Button
        val btn6 =
            findViewById<View>(R.id.button6) as Button
        val btn7 =
            findViewById<View>(R.id.button7) as Button
        val btn8 =
            findViewById<View>(R.id.button8) as Button
        val btn9 =
            findViewById<View>(R.id.button9) as Button
    }
}