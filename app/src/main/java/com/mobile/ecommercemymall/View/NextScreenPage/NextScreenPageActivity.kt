package com.mobile.ecommercemymall.View.NextScreenPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.Login.LoginActivity
import kotlinx.android.synthetic.main.activity_next_screen_page.*

class NextScreenPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_screen_page)

        btn_next.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}