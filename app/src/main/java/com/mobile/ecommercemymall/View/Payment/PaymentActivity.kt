package com.mobile.ecommercemymall.View.Payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.DetailsCheckout.DetailsCheckoutActivity
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        btn_save_payment.setOnClickListener {
            val intent = Intent(this, DetailsCheckoutActivity::class.java)
            startActivity(intent)
        }

        if (check1.isChecked){
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_pimary)
        }else{
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_secondary)
        }
        if (check2.isChecked){
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_pimary)
        }else{
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_secondary)
        }
        if (check3.isChecked){
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_pimary)
        }else{
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_secondary)
        }
        if (check4.isChecked){
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_pimary)
        }else{
            changeIcon(btn_save_payment,R.drawable.bg_btn_address_secondary)
        }
    }

    private fun changeIcon(button: Button, drawable: Int) {
        button.setBackgroundResource(drawable)
    }
}