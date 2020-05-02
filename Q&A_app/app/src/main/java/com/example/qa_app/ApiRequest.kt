package com.example.qa_app

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class ApiRequest(context: Context, group: String?, category: String? ) {
    private val mContext: Context
    private var group = "global"
    private var category = "math"
    private val urlGet = "http://35.173.127.87:8000/api/questions"
    private val queue: RequestQueue

    init {
        mContext = context
        queue = Volley.newRequestQueue(mContext)
        if (group != null) {
            this.group = group
        }
        if (category != null) {
            this.category = category
        }
    }


    fun fetchQuestions() {
        val stringRequest = object : StringRequest(
            Request.Method.POST, urlGet,
            Response.Listener<String> { response ->
                try {
                    val titleSet = ArrayList<String>()
                    val infoSet = ArrayList<String>()
                    val idSet = ArrayList<String>()

                    val obj = JSONArray(response)
                    val size = obj.length()
                    for (i in 0 until size) {
                        val question = obj.getJSONObject(i)
                        titleSet.add(question["title"].toString())
                        infoSet.add(question["content"].toString())
                        idSet.add(question["id"].toString())
                    }

                    // after retrieval of data, transfer over to Groups activity
                    val intent = Intent(mContext, QuestionsActivity::class.java)
                    intent.putExtra("title_set", titleSet)
                    intent.putExtra("info_set", infoSet)
                    intent.putExtra("question_id_set", idSet)
                    intent.putExtra("group", group)
                    intent.putExtra("category", category)
                    mContext.startActivity(intent)

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