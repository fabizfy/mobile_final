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
    //private val titles = ArrayList<String>()
    //private val contents = ArrayList<String>()
    //private var done = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)
        val bundle: Bundle? = intent.extras
        val titleSet = bundle?.get("title_set")
        var infoSet = bundle?.get("info_set")


        val listView = findViewById<ListView>(R.id.main_listview)
        listView.adapter = listViewAdapter(this, titleSet as ArrayList<String>,
            infoSet as ArrayList<String>
        )
    }



    private class listViewAdapter(context: Context, titleSet: ArrayList<String>, infoSet:ArrayList<String>): BaseAdapter() {
        private val mContext: Context
        private val titleSet: ArrayList<String>
        private val infoSet: ArrayList<String>


        private val names = arrayListOf<String>(
            "Muniker Aragon", "Steve Jobs", "Mark Zuckerberg", "Barack Obama"
        )
        init{
            mContext = context
            this.titleSet = titleSet
            this.infoSet = infoSet

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
            nameTextView.text = titleSet[position]
            //nameTextView.text = names.get(position)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = infoSet[position]
            return rowMain

        }


    }
}
