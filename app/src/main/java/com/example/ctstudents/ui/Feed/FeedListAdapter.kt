package com.example.ctstudents.ui.Feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ctstudents.R

class FeedListAdapter(private val listener: NewsItemClick) :
    RecyclerView.Adapter<FeedViewHolder>() {

    private val items: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_activity, parent, false)

        val viewHolder = FeedViewHolder(view)

        view.setOnClickListener {
            listener.onTtemClick(items[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = items[position]
        holder.title.text = currentItem.title
        holder.author.text = currentItem.author
        holder.description.text = currentItem.description
        Glide.with(holder.itemView.context).load(currentItem.urlToImage).into(holder.newsImage)

    }

    fun updateNews(updatedNews: ArrayList<News>){
        items.clear()
        items.addAll(updatedNews)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.newsTitle)
    val description : TextView = itemView.findViewById(R.id.newsDescription)
    val newsImage : ImageView = itemView.findViewById(R.id.newsImage)
    val author : TextView = itemView.findViewById(R.id.newsAuthorName)

}

interface NewsItemClick {
    fun onTtemClick(Items: News)
}
