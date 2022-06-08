package com.example.ctstudents.ui.Home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ctstudents.R

class Home : Fragment() {

    lateinit var attendence: TextView
    lateinit var assigment: TextView
    lateinit var notes: TextView
    lateinit var cgpa: TextView


    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
        attendence = inflater.inflate(R.id.txtAttendence, container, false) as TextView
        attendence.setOnClickListener {
            val intent = Intent(getActivity(), attendence::class.java)
            getActivity()?.startActivity(intent)
        }
    }


}