package com.example.qa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.*
import org.json.JSONArray
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    private val titleSet = ArrayList<String>()
    private val infoSet = ArrayList<String>()

    private val group = "WSU"
    private val category = "math"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            fetchInfo()
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
                    val size = obj.length()
                    for(i in 0 until size){
                        val question = obj.getJSONObject(i)
                        titleSet.add(question["title"].toString())
                        infoSet.add(question["content"].toString())
                    }

                    // after retrieval of data, transfer over to Groups activity
                    var intent = Intent(this, Groups::class.java)
                    intent.putExtra("title_set", titleSet)
                    intent.putExtra("info_set", infoSet)
                    startActivity(intent)

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
                params.put("group", group)
                params.put("category", category)
                return params
            }
        }
        //adding request to queue
        queue.add(stringRequest)
    }


}
