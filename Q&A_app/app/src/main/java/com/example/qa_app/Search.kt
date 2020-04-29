package com.example.qa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.google.android.material.bottomnavigation.BottomNavigationView

class Search : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // set search Icon to appear highlighted
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.search

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
                    val intent = Intent(this, Profile::class.java)
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
