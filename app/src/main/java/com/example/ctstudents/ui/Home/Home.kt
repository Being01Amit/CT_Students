package com.example.ctstudents.ui.Home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ctstudents.R
import com.google.firebase.auth.FirebaseAuth

private lateinit var auth: FirebaseAuth


lateinit var HomeFeed: View

class Home : Fragment() {


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        HomeFeed = inflater.inflate(R.layout.fragment_home, container, false)

        val btnattendance : TextView = HomeFeed.findViewById(R.id.txt_attendance)
        btnattendance.setOnClickListener {
            Toast.makeText(activity,"marks is clicked",Toast.LENGTH_LONG).show()
            val intent = Intent(activity, marksCal::class.java)
            startActivity(intent)
        }
//        auth = Firebase.auth
        return HomeFeed
    }
//
//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser == null){
//            val intent = Intent(activity, SignInActivity::class.java)
//            requireActivity().startActivity(intent)
//        }
//    }

}