package com.example.ctstudents

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ctstudents.ui.Home.HomeFeed
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    lateinit var fullName: EditText
    lateinit var registerEmail: EditText
    lateinit var registerPassword: EditText
    lateinit var registerButton: Button
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        registerButton = findViewById(R.id.btnRegister)

        mAuth = FirebaseAuth.getInstance()
        registerButton.setOnClickListener {
            createUser()
        }


    }

    fun createUser() {

        fullName = findViewById(R.id.etSignUp)
        registerEmail = findViewById(R.id.etEmailPhoneNumber)
        registerPassword = findViewById(R.id.etRegisterPassword)

        var email = registerEmail.text.toString()
        var name = fullName.text.toString()
        var password = registerPassword.text.toString()

        if (TextUtils.isEmpty(email)) {
            registerEmail.setError("email cannot be empty")
            registerPassword.requestFocus()
        } else if (TextUtils.isEmpty(password)) {
            registerPassword.setError("email cannot be empty")
            registerEmail.requestFocus()
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")
                        val user = mAuth.currentUser
                        val intent : Intent = Intent(this, HomeFeed::class.java)

                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }

}