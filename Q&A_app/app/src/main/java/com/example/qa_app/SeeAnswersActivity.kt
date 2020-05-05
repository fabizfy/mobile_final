package com.example.qa_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SeeAnswersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_answers)

        // extract attributes that were passed from previous activity
        val bundle: Bundle? = intent.extras
        var questionId = bundle?.get("question_id")
        val title = bundle?.get("question_title")
        val content = bundle?.get("question_content")
        val responseSet = bundle?.get("response_set") as ArrayList<String>

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.questions -> {
                    val appAPI = ApiRequest(this, null, null)
                    appAPI.fetchQuestions()
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

        // display question title
        val titleTextBox = findViewById<TextView>(R.id.question_title)
        titleTextBox.text = title.toString()
        // display question content
        val contentTextBox = findViewById<TextView>(R.id.question_content)
        contentTextBox.text = content.toString()

        // create list view and configure its adapter
        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = ListViewAdapter(this, responseSet)

        // handle touch for responding to question
        val addAnswer = findViewById<Button>(R.id.respond_btn)
        addAnswer.setOnClickListener{
            val intent = Intent(this, PublishAnswerActivity::class.java)
            intent.putExtra("question_id", questionId as String)
            this.startActivity(intent)
        }

    }


    class ListViewAdapter(context: Context, responseSet:ArrayList<String>): BaseAdapter() {
        private val mContext: Context
        private val responseSet: ArrayList<String>
        init{
            mContext = context
            this.responseSet = responseSet
        }

        // responsible for how many rows in list
        override fun getCount(): Int {
            return responseSet.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return position
        }

        // responsible for rendering each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_answers, null, false)
            val positionTextView = rowMain.findViewById<TextView>(R.id.answer_textview)
            positionTextView.text = responseSet[position]
            return rowMain
        }
    }
}
