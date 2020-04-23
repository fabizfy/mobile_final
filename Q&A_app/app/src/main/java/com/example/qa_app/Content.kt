package com.example.qa_app

import android.content.Context
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class Content(context:Context, group:String?, category:String?) {

    private val group:String?
    private val category:String?
    val title = ArrayList<String>()
    val content = ArrayList<String>()
    private val mContext: Context

    init{
        this.group = group
        this.category = category
        mContext = context
    }

    fun fetchInfo() {
        var url = "http://35.173.127.87:8000/api/questions"
        val queue = Volley.newRequestQueue(mContext)
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
                        title.add(question["title"].toString())
                        content.add(question["content"].toString())

                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(mContext, volleyError.message, Toast.LENGTH_LONG).show()
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
    }

    fun getTitles(): ArrayList<String> {
        return title
    }

    fun getContents(): ArrayList<String> {
        return content
    }

}