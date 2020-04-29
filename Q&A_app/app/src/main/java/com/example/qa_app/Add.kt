package com.example.qa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.google.android.material.bottomnavigation.BottomNavigationView

class Add : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.add_question
        bottomNav.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId) {
                R.id.questions -> {
                    val intent = Intent(this, Groups::class.java)
                    startActivity(intent)
                    false
                }
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    false
                }
                R.id.profile -> {
                    // do something
                    false
                }
                R.id.add_question -> {
                    // do something
                    true
                }
                R.id.search -> {
                    // do something
                    false
                }
                else -> true
            }
        }
    }
}
