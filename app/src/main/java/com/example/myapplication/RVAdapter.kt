package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Quote

class RVAdapter(private val mList: List<com.example.myapplication.model.Result>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        // sets the image to the imageview from our itemHolder class
        holder.tv_content.text=ItemsViewModel.content
        // sets the text to the textview from our itemHolder class
        holder.tv_author.text = "Author- "+ItemsViewModel.author
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tv_content: TextView = itemView.findViewById(R.id.tv_content)
        val tv_author: TextView = itemView.findViewById(R.id.tv_author)
    }
}