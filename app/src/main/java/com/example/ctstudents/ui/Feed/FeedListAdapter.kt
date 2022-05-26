package com.example.ctstudents.ui.Feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ctstudents.R

class FeedListAdapter(val items: ArrayList<String>) : RecyclerView.Adapter<FeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_activity, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = items[position]
        holder.title.text = currentItem
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.txtFeedTitle)

}