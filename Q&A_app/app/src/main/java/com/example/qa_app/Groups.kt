package com.example.qa_app

import android.content.Context
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
import org.json.JSONArray
import org.json.JSONException

class Groups : AppCompatActivity() {
    private val titles = ArrayList<String>()
    private val contents = ArrayList<String>()
    private var done = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)
        fetchInfo()
        while(done == false) {
            println("False")
        }
        println("True")
        println("Array after initalizing:" + titles.size)
        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = listViewAdapter(this, titles, contents)
    }



    private class listViewAdapter(context: Context, titles: ArrayList<String>, contents:ArrayList<String>): BaseAdapter() {
        private val mContext: Context
        private val titles: ArrayList<String>
        private val contents: ArrayList<String>

        var group = "WSU"
        var category = "Math"

        private val names = arrayListOf<String>(
            "Muniker Aragon", "Steve Jobs", "Mark Zuckerberg", "Barack Obama"
        )
        init{
            mContext = context
            //questions = Content(context, group, category)
            //questions.fetchInfo()
            this.titles = titles
            //println(titles)
            this.contents = contents
            //println(contents)

        }
        // responsible for how many rows in list
        override fun getCount(): Int {
            return names.size
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
            //nameTextView.text = titles[position]
            nameTextView.text = names.get(position)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Random content"
            return rowMain

        }


    }


    private fun fetchInfo() {
        var url = "http://35.173.127.87:8000/api/questions"
        val queue = Volley.newRequestQueue(this)
        //creating volley string request
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                try {
                    val obj = JSONArray(response)
                    println(obj.toString())
                    val size = obj.length()
                    println("Size of array" + size)
                    for(i in 0 until size){
                        val question = obj.getJSONObject(i)
                        titles.add(question["title"].toString())
                        contents.add(question["content"].toString())

                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    //Toast.makeText(this, volleyError.message, Toast.LENGTH_LONG).show()
                }
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("group", "WSU")
                params.put("category", "math")
                return params
            }
        }

        //adding request to queue
        queue.add(stringRequest)
        done = true
    }

}
