package com.example.ctstudents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
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

    lateinit var auth: FirebaseAuth
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

//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()


        //SignIn Activity
        auth = Firebase.auth

//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestEmail()
//            .build()
//        // Build a GoogleSignInClient with the options specified by gso.
//        var mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
//        // Set the dimensions of the sign-in button.
//        // Set the dimensions of the sign-in button.
//        val signInButton = findViewById<SignInButton>(R.id.sign_in_button)
//        signInButton.setSize(SignInButton.SIZE_STANDARD)


//        Sign in with email password section


        googleLogin = findViewById(R.id.sign_in_button)
        email = findViewById(R.id.etSignIn)
        password = findViewById(R.id.etPassword)
        signIn = findViewById(R.id.btnSignIn)

//        Google SignIn Button
        googleLogin.setOnClickListener {
            val signInIntent = mGoogleSignInClient!!.signInIntent
            startActivityForResult(signInIntent, 9001)
        }
        signIn.setOnClickListener {
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task
                    ->
                    if (task.isSuccessful) {
                        //Sign in success
//                        val user = auth.currentUser
                        Log.d("user", "SignIn with Google is successful")
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {

                        //if signIn failed, Display a message to  the user
                        Log.w("user", "signInwithEmailFailed", task.exception)
                        Toast.makeText(baseContext, "Authentication Failed", Toast.LENGTH_LONG)
                            .show()
                    }
                }
        }


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

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun reload() {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode === 9001) {
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
                Log.d("TAG", "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken.toString())
                Log.d("TAG", "token:" + account.idToken.toString())

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this,
                OnCompleteListener<AuthResult?> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("TAG", "signInWithCredential:success")
                        val user: FirebaseUser? = auth.currentUser
                        //updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("TAG", "signInWithCredential:failure", task.exception)
                        // updateUI(null)
                    }
                })
    }
}