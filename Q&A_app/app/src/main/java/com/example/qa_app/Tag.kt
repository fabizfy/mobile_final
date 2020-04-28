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
        btn.setOnClickListener {
            val int1 = Intent(this@Tag, Psychology::class.java)
            startActivity(int1)
        }
        btn1.setOnClickListener {
            val int2 = Intent(this@Tag, Art::class.java)
            startActivity(int2)
        }
        btn2.setOnClickListener {
            val int3 = Intent(this@Tag, Mathematics::class.java)
            startActivity(int3)
        }
        btn3.setOnClickListener {
            val int4 = Intent(this@Tag, Physics::class.java)
            startActivity(int4)
        }
        btn4.setOnClickListener {
            val int5 = Intent(this@Tag, Chemistry::class.java)
            startActivity(int5)
        }
        btn5.setOnClickListener {
            val int6 = Intent(this@Tag, Geography::class.java)
            startActivity(int6)
        }
        btn6.setOnClickListener {
            val int7 = Intent(this@Tag, Grammar::class.java)
            startActivity(int7)
        }
        btn7.setOnClickListener {
            val int8 = Intent(this@Tag, Literature::class.java)
            startActivity(int8)
        }
        btn8.setOnClickListener {
            val int9 = Intent(this@Tag, Science::class.java)
            startActivity(int9)
        }
        btn9.setOnClickListener {
            val int10 = Intent(this@Tag, History::class.java)
            startActivity(int10)
        }
    }
}