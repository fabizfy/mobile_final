package com.example.qa_app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONException

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        // handle presses in bottom nav ba
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.questions
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.questions -> {

                    true
                }
                R.id.search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    false
                }
                else -> true
            }
        }

        // extract attributes that were passed from previous activity
        val bundle: Bundle? = intent.extras
        val group = bundle?.get("group")
        val category = bundle?.get("category")
        val titleSet = bundle?.get("title_set")
        val infoSet = bundle?.get("info_set")
        val idSet = bundle?.get("question_id_set")

        // handle presses of POST button
        var fab = findViewById<FloatingActionButton>(R.id.floating_action_button)
        fab.setOnClickListener{
            Toast.makeText(this,"Fab button clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PublishActivity::class.java)
            intent.putExtra("group", group as String)
            intent.putExtra("category", category as String)
            startActivity(intent)
        }

        // create list view and configure its adapter
        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = listViewAdapter(this, titleSet as ArrayList<String>,
            infoSet as ArrayList<String>, idSet as ArrayList<String>
        )
            /*listView.setOnItemClickListener{ parent, view, position, id ->
            val row = parent.getItemAtPosition(position)
            Toast.makeText(this, row.toString(), Toast.LENGTH_LONG).show()
        }*/
    }



    class listViewAdapter(context: Context, titleSet: ArrayList<String>, infoSet:ArrayList<String>, idSet:ArrayList<String>): BaseAdapter() {
        private val mContext: Context
        private val titleSet: ArrayList<String>
        private val infoSet: ArrayList<String>
        private val idSet: ArrayList<String>
        init{
            mContext = context
            this.titleSet = titleSet
            this.infoSet = infoSet
            this.idSet = idSet

        }
        // responsible for how many rows in list
        override fun getCount(): Int {
            //return names.size
            return titleSet.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        // responsible for rendering each row
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, null, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = titleSet[position] + idSet[position]
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = infoSet[position]
            return rowMain

        }


    }
}


// when user clicks on a question ---> you will be able to see answers and add an answer
// use Apirequest to request all answere from a given question id ----> go to answer activity
// have button to add an answer
