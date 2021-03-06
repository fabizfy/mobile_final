package com.example.qa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_add.*

class PublishAnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publish_answer)

        // extract attributes that were passed from previous activity
        val bundle: Bundle? = intent.extras
        val questionId = bundle?.get("question_id")
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.questions -> {
                    val appAPI = ApiRequest(this, null, null)
                    appAPI.fetchQuestions()
                    false
                }
                R.id.profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    false
                }
                R.id.search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    false
                }
                else -> true
            }
        }

        // handle presses in bottom nav bar
        val topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)
        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.post -> {
                    // Handle post icon press
                    Toast.makeText(this, "Post item has been pressed", Toast.LENGTH_SHORT).show()
                    val publishApi = ApiPublish(this, "", "", "","")
                    val content = contentTextField.editText?.text.toString()
                    publishApi.publishAnswer(questionId as String, content)
                    finish()
                    true
                }
                R.id.file_upload -> {
                    // Handle search icon press
                    Toast.makeText(this, "File upload item has been pressed", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.image_upload -> {
                    // Handle more item (inside overflow menu) press
                    Toast.makeText(this, "File upload item has been pressed", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
