package com.example.qa_app

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class ApiPublish(context: Context, group: String, category: String, title: String, content: String) {
    private val group: String
    private val category: String
    private val title: String
    private val content: String
    private val mContext: Context
    private val queue: RequestQueue
    private val urlPost: String

    init{
        mContext = context
        queue = Volley.newRequestQueue(mContext)
        urlPost = "http://35.173.127.87:8000/api/publish"
        this.title = title
        this.content = content
        this.group = group
        this.category = category
    }

    fun publishQuestion() {
        val stringRequest = object : StringRequest(
            Request.Method.POST, urlPost,
            Response.Listener<String> { response ->
                try {
                    val obj = JSONArray(response)
                    // after retrieval of data, transfer over to Main activity
                    val intent = Intent(mContext, MainActivity::class.java)
                    mContext.startActivity(intent)

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(mContext, "Error publishing question", Toast.LENGTH_LONG).show()
                }
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String> {
                val params = HashMap<String, String>()
                params.put("group", group)
                params.put("category", category)
                params.put("title", title)
                params.put("content", content)
                return params
            }
        }
        //adding request to queue
        queue.add(stringRequest)
    }
}