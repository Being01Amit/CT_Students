package com.example.ctstudents.ui.Feed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.ctstudents.R
import org.json.JSONException

open class FeedFragment : Fragment(), NewsItemClick {

    lateinit var recyclerFeedFragment: LinearLayoutManager
    lateinit var NewsFeed: View
    lateinit var feedAdapter: FeedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        NewsFeed = inflater.inflate(R.layout.fragment_feed, container, false)

        recyclerFeedFragment = LinearLayoutManager(NewsFeed.context)
        fetchData()
        val feedAdapter =
            FeedListAdapter(this)  // recyclerFeedFragment.adapter = feedAdapter
        val recyclerview: RecyclerView = NewsFeed.findViewById(R.id.recycler_view)
        recyclerview.layoutManager = recyclerFeedFragment
        recyclerview.adapter = feedAdapter
        return NewsFeed


//        ImgView = NewsFeed.findViewById(R.id.newsImage)
//        requestQueue = Volley.newRequestQueue(NewsFeed.context)
//        loadFeed()
//        return NewsFeed
    }

    private fun fetchData() {
        val url =
            "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=79a7ecb9953d4d858d3a280dcdf3f06f"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            {
                val NewsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()
                for (i in 0 until NewsJsonArray.length()) {
                    val newsJsonObject = NewsJsonArray.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("description"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }
                feedAdapter.updateNews(newsArray)

            }, {
                Log.d("VolleyError", "Something went wrong")
            }
        )
        MySingleton.getInstance(NewsFeed.context).addToRequestQueue(jsonObjectRequest)
    }

    override fun onTtemClick(Items: News) {

    }
}



