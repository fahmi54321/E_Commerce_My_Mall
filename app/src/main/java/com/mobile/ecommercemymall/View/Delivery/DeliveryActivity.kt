package com.mobile.ecommercemymall.View.Delivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.AddressMenu.AddressMenuActivity
import com.mobile.ecommercemymall.View.Payment.PaymentActivity
import kotlinx.android.synthetic.main.activity_delivery.*

class DeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)

        btn_save_delivery.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        if (check1.isChecked){
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            changeIcon(btn_save_delivery,R.drawable.bg_btn_address_pimary)
        }else{
            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()
            changeIcon(btn_save_delivery,R.drawable.bg_btn_address_secondary)
        }

        if (check2.isChecked){
            changeIcon(btn_save_delivery,R.drawable.bg_btn_address_pimary)
        }else{
            changeIcon(btn_save_delivery,R.drawable.bg_btn_address_secondary)
        }

        if (check3.isChecked){
            changeIcon(btn_save_delivery,R.drawable.bg_btn_address_pimary)
        }else{
            changeIcon(btn_save_delivery,R.drawable.bg_btn_address_secondary)
        }
    }

    private fun changeIcon(button: Button, drawable: Int) {
        button.setBackgroundResource(drawable)
    }
}