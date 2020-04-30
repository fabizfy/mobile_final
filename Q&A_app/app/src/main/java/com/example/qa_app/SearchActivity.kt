package com.example.qa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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

        // set search Icon to appear highlighted
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.search

        // handle presses in bottom nav bar
        bottomNav.setOnNavigationItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.questions -> {
                    val appAPI = ApiRequest(this, null, null)
                    appAPI.fetchQuestions()
                    false
                }
                R.id.home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    false
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    false
                }
                R.id.search -> {
                    // do something
                    true
                }
                else -> true
            }
        }
    }
}
