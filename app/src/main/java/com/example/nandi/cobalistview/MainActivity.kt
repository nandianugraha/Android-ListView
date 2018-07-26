package com.example.nandi.cobalistview

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<View>(R.id.listView) as ListView

        listView.adapter = myAdapter(this)
    }

    private class myAdapter(context: Context): BaseAdapter() {

        private val myContext: Context

        private val names = arrayListOf<String>(
                "Nandia Nugraha", "Christian Eka", "Abdul Ali", "Yanuar Ali"
        )

        init {
            myContext = context
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(p0: Int): Any {
            return "TEST STRING"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(myContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)
            val nameRow = rowMain.findViewById<TextView>(R.id.txt1)
            nameRow.text = names.get(position)

            val positionRow = rowMain.findViewById<TextView>(R.id.txt2)
            positionRow.text = "Row Number: $position"
            return rowMain
/*            val textView = TextView(myContext)
            textView.text = "HERE is My Row with Text View"
            return textView*/
        }
    }
}
