package com.example.ctstudents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ctstudents.ui.Home.Home
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SignInActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var signIn: Button
    lateinit var register: TextView
    lateinit var recoverPassword: TextView
    lateinit var email: EditText
    lateinit var password: EditText
    private var mGoogleSignInClient: GoogleSignInClient? = null


    private lateinit var googleLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        mAuth = Firebase.auth



        email = findViewById(R.id.etSignIn)
        password = findViewById(R.id.etPassword)
        signIn = findViewById(R.id.btnSignIn)


//      Created Intent for the Recover Password here
        recoverPassword = findViewById(R.id.txtRecoverPassword)
        recoverPassword.setOnClickListener {
            val intent = Intent(this, RecoverPassword::class.java)
            startActivity(intent)
            finish()
        }


//      Created Intent for Registration
        register = findViewById(R.id.txtRegister)
        register.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}