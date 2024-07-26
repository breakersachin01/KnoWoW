package com.example.knowow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.knowow.R
import com.google.android.material.imageview.ShapeableImageView

class CFRecyclerViewAdapter(private val context: Context, private val dataSet: ArrayList<FactCardModel>) : RecyclerView.Adapter<CFRecyclerViewAdapter.ViewHolder>() {

    // ViewHolder class to hold references to the views
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textView)
        val titleImage : ShapeableImageView = view.findViewById(R.id.title_image)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Inflate the item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data item for this position
        val fact = dataSet[position]
        // Bind the data to the view elements
        holder.textView.text = fact.fact
        holder.titleImage.setImageResource(fact.image)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
