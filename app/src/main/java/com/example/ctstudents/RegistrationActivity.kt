package com.example.ctstudents

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    lateinit var fullName: EditText
    lateinit var registerEmail: EditText
    lateinit var registerPassword: EditText
    lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        fullName = findViewById(R.id.etSignUp)
        registerEmail = findViewById(R.id.etEmailPhoneNumber)
        registerPassword = findViewById(R.id.etRegisterPassword)


    }
}