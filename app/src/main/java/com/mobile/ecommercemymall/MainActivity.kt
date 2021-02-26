package com.mobile.ecommercemymall

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobile.ecommercemymall.View.Home.HomeActivity1
import com.mobile.ecommercemymall.View.Home.HomeActivity2
import com.mobile.ecommercemymall.View.Home.HomeActivity3
import com.mobile.ecommercemymall.View.Home.HomeActivity4
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        home1.setOnClickListener {
            val intent = Intent(this,HomeActivity1::class.java)
            startActivity(intent)
        }

        home2.setOnClickListener {
            val intent = Intent(this,HomeActivity2::class.java)
            startActivity(intent)
        }

        home3.setOnClickListener {
            val intent = Intent(this,HomeActivity3::class.java)
            startActivity(intent)
        }

        home4.setOnClickListener {
            val intent = Intent(this,HomeActivity4::class.java)
            startActivity(intent)
        }
    }
}