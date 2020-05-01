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

        // set search Icon to appear highlighted
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.search

        // handle touch in bottom nav bar
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

    // button handler
    fun buttonClick(view: View) {
        val buttonSelected = view as Button
        val requestApi : ApiRequest
        val category: String

        when (buttonSelected.id) {
            R.id.art_btn -> category = "art"
            R.id.history_btn -> category = "history"
            R.id.science_btn -> category = "science"
            R.id.biology_btn -> category = "biology"
            R.id.math_btn -> category = "math"
            R.id.physics_btn -> category = "physics"
            R.id.health_btn -> category = "health"
            R.id.music_btn -> category = "music"
            R.id.english_btn -> category = "english"
            else -> category = "esl"
        }

        requestApi = ApiRequest(this, null, category)
        requestApi.fetchQuestions()
    }
}
