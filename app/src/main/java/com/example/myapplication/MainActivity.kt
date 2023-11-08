package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var suma = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val textEdit: EditText = findViewById(R.id.editTextText)
        val addButton: Button = findViewById(R.id.addButton)
        val sumButton: Button = findViewById(R.id.sumButton)
        val image: ImageView = findViewById(R.id.nextImage)

        image.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }
        val items = mutableListOf<String>(
            "Hello",
            "World",
            "Red",
            "blue",
            "Word"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, items)
        listView.adapter = adapter

        addButton.setOnClickListener {
            items.add(textEdit.text.toString())
            adapter.notifyDataSetChanged()
        }
        sumButton.setOnClickListener {
            Toast.makeText(this, suma.toString(), Toast.LENGTH_SHORT).show()
            suma = ""
        }
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, items[position], Toast.LENGTH_SHORT).show()
            suma += items[position]
            adapter.remove(items[position])
        }
    }
}