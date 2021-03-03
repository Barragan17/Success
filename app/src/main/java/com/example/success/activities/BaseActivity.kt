package com.example.success.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.widget.Toast
import com.example.success.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.dialog_progress.*
import android.os.Handler
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    private lateinit var mProgressDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun showProgressDialog(text: String){
        mProgressDialog = Dialog(this)
        mProgressDialog.setContentView(R.layout.dialog_progress)
        mProgressDialog.tv_progress_text.text = text
        mProgressDialog.show()
    }

    fun hideProgressDialog(){
        mProgressDialog.dismiss()
    }

    fun getCurrentUserId(): String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }

    fun doubleBackToExit(){
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press back once again to exit", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper()).postDelayed({

        }, 2000)
    }

    fun showErrorSnackBar(message: String){
        val snackBar = Snackbar.make(findViewById(android.R.id.content),
            message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.snackbar_error_color))
        snackBar.show()
    }


}