package com.example.ctstudents.ui.Feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ctstudents.R

//class FeedFragment : AppCompatActivity() {
//
//    lateinit var recyclerFeedFragment: LinearLayoutManager
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_feed)
//        recyclerFeedFragment = LinearLayoutManager(this)
//        val items = fetchData()
//        val feedAdapter: FeedListAdapter = FeedListAdapter(items)
//        // recyclerFeedFragment.adapter = feedAdapter
//        var recyclerview: RecyclerView = findViewById(R.id.recyclerFeed);
//        recyclerview.layoutManager = recyclerFeedFragment
//        recyclerview.adapter = feedAdapter
//    }
//



class FeedFragment : Fragment() {
    lateinit var recyclerFeedFragment: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view: View = inflater.inflate(R.layout.fragment_feed, container, false)
        recyclerFeedFragment = LinearLayoutManager(view.context)
        val items = fetchData()
        val feedAdapter: FeedListAdapter = FeedListAdapter(items)
       // recyclerFeedFragment.adapter = feedAdapter
        var recyclerview: RecyclerView = view.findViewById(R.id.recyclerFeed);
        recyclerview.layoutManager = recyclerFeedFragment
        recyclerview.adapter = feedAdapter
        return view
    }

    private fun fetchData(): ArrayList<String> {
        var list = ArrayList<String>()
        for (i in 0 until 100) {
            list.add("item $i")
        }
        return list

    }

}