package com.example.success.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.example.success.R
import com.example.success.models.Quotes
import com.example.success.utils.Constants
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.activity_splash_quotes.*

class SplashQuotesActivity : AppCompatActivity() {

    private var mCurrentPosition: Int = 1
    lateinit var mQuotesList: ArrayList<Quotes>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_quotes)

        mQuotesList = Constants.getQuotes()

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setQuotes()

        val typeFace: Typeface = Typeface.createFromAsset(assets, "carbon bl.ttf")
        tv_quotes.typeface = typeFace

        Handler(Looper.getMainLooper()).postDelayed({

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }

    private fun setQuotes(){
        val quotes = mQuotesList[mCurrentPosition - 1]

        tv_quotes.text = quotes.quotes
        layout_quotes_splash.setBackgroundResource(quotes.background)
    }
}