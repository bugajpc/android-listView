package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val list1: ListView = findViewById(R.id.newlist1)
        val list2: ListView = findViewById(R.id.newlist2)

        val items1 = mutableListOf<String>(
            "Hello",
            "World",
            "Red",
            "blue",
            "Word"
        )
        val items2 = mutableListOf<String>()

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, items1)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, items2)
        list1.adapter = adapter1
        list2.adapter = adapter2
        list1.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, items1[position], Toast.LENGTH_SHORT).show()
            items2.add(items1[position])
            adapter2.notifyDataSetChanged()
            adapter1.remove(items1[position])
        }

        list2.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, items2[position], Toast.LENGTH_SHORT).show()
            items1.add(items2[position])
            adapter1.notifyDataSetChanged()
            adapter2.remove(items2[position])
        }
    }
}