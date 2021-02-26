package com.mobile.ecommercemymall.View.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.NextScreenPage.NextScreenPageActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, NextScreenPageActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}