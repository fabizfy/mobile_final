package com.example.qa_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem

class All : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all)

        var tab = findViewById<TabItem>(R.id.tabAll)
        val view = findViewById<ViewPager>(R.id.viewer)
        tab.setOnClickListener{
            // Inflate the layout for this fragment
        }
    }
}
