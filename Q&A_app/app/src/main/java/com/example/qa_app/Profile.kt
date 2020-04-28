package com.example.qa_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Profile  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val btn =
            findViewById<View>(R.id.button) as Button

        btn.setOnClickListener {
            val int1 = Intent(this@Profile, Psychology::class.java)
            startActivity(int1)
        }
    }

}