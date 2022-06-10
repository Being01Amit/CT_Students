package com.example.ctstudents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ctstudents.ui.Home.HomeFeed
import com.example.ctstudents.ui.Profile.ProfileFragment

class Credentials : AppCompatActivity() {
    lateinit var studyProgram : EditText
    lateinit var UniRollNo : EditText
    lateinit var PhoneNo : EditText
    lateinit var department : EditText
    lateinit var degree: EditText
    lateinit var LetsGo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credentials)

        studyProgram = findViewById(R.id.txtEnterStudyProgram)
        UniRollNo = findViewById(R.id.txtUnversityNo)
        PhoneNo = findViewById(R.id.txtEnterPhoneNo)
        department = findViewById(R.id.txtEnterDepartment)
        degree = findViewById(R.id.txtEnterDegree)
        LetsGo = findViewById(R.id.btnLetsGo)

        val sp = studyProgram.text.toString()
        val urn = UniRollNo.text.toString()
        val pn = PhoneNo.text.toString()
        val dm = department.text.toString()
        val dg = degree.text.toString()

        LetsGo.setOnClickListener {
            if (checkCredentials() != null){
                val intent = Intent(this, ProfileFragment::class.java)
                intent.putExtra("study",sp)
                intent.putExtra("UniversityNo",urn)
                intent.putExtra("PhoneNo",pn)
                intent.putExtra("Department",dm)
                intent.putExtra("Degree",dg)
                startActivity(intent)
                finish()
            } else{
                Toast.makeText(this,"Enter All Credentials",Toast.LENGTH_LONG)
            }
        }


    }

    fun checkCredentials(){
        val sp = studyProgram.text.toString()
        val urn = UniRollNo.text.toString()
        val pn = PhoneNo.text.toString()
        val dm = department.text.toString()
        val dg = degree.text.toString()

        if (TextUtils.isEmpty(sp)) {
            studyProgram.setError("email cannot be empty")
        } else if (TextUtils.isEmpty(urn)) {
            UniRollNo.setError("email cannot be empty")
        } else if (TextUtils.isEmpty(pn)) {
            PhoneNo.setError("email cannot be empty")
        } else if (TextUtils.isEmpty(dm)) {
            department.setError("email cannot be empty")
        } else if (TextUtils.isEmpty(dg)) {
            degree.setError("email cannot be empty")
        }
    }
}