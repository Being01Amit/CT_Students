package com.example.ctstudents

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RecoverPassword : AppCompatActivity() {

    lateinit var registerbtn: Button
    lateinit var recoverEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        registerbtn = findViewById(R.id.btnRecover)

        recoverEmail = findViewById(R.id.etRecoverEmail)
        recoverEmail.text.toString()

        // here creating the Toast when button is clicked
        registerbtn.setOnClickListener {

            Toast.makeText(baseContext,"Check your email",Toast.LENGTH_LONG)
                .show()
        }
    }
}