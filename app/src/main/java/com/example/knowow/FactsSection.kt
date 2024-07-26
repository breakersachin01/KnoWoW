package com.example.knowow

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FactsSection : AppCompatActivity() {

    private lateinit var factsArray: Array<String>
    private lateinit var adapter: CFRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts_section)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.actColor)))
        val category = intent.getStringExtra("category")
        supportActionBar?.title = category
        val factsList: ArrayList<FactCardModel> = addFact()


        val rV = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = CFRecyclerViewAdapter(this, factsList)
        rV.adapter = adapter
        rV.layoutManager = LinearLayoutManager(this)

    }

    private fun addFact() : ArrayList<FactCardModel> {
        // Loop through the facts array and add them to the list
        // Create a list of facts
        factsArray = intent.getStringArrayExtra("factsArray") ?: emptyArray()
        val image = intent.getIntExtra("image", 0)
        val factsList = ArrayList<FactCardModel>()
        for (fact in factsArray) {
            val factCard = FactCardModel(fact, image)
            factsList.add(factCard)
        }
        return factsList
    }


}