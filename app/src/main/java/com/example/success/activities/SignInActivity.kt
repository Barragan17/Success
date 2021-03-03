package com.example.success.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.example.success.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : BaseActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setupActionBar()

        auth = FirebaseAuth.getInstance()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        btn_sign_in.setOnClickListener {
            signInRegisteredUser()
        }
    }

    private fun setupActionBar(){
        setSupportActionBar(toolbar_sign_in_activity)

        val actionBar = supportActionBar
        if(actionBar!= null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        }

        toolbar_sign_in_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun signInRegisteredUser(){
        val email = et_sign_in_email.text.toString().trim{ it <= ' '}
        val password = et_sign_in_password.text.toString().trim { it <= ' '}

        if(validateForm(email, password)){
            showProgressDialog(resources.getString(R.string.please_wait))

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    hideProgressDialog()
                    if (task.isSuccessful){
                        Log.d("Sign In", "SignInWithEmail:Success")
                        val user = auth.currentUser
                        startActivity(Intent(this, SplashQuotesActivity::class.java))
                    }else{
                        Log.w("Sign In", "SignInWithEmail:Failure")
                        Toast.makeText(baseContext, "Authentication Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun validateForm(email: String, password: String): Boolean{
        return when{
            TextUtils.isEmpty(email) ->{
                showErrorSnackBar("Please Enter an Emai")
                false
            }
            TextUtils.isEmpty(password) ->{
                showErrorSnackBar("Please Enter a Password")
                false
            }else ->{
                true
            }
        }
    }
}