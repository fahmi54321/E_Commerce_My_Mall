package com.mobile.ecommercemymall.View.DetailsMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mobile.ecommercemymall.Helpers.formatPrice
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.CheckoutPage.CheckoutActivity
import com.mobile.inkadosumbar.Constants.Constants
import kotlinx.android.synthetic.main.activity_details_menu1.*

class DetailsMenuActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_menu1)

        val getData = intent.getParcelableExtra<ResultItemProducts>("data")

        var constants: Constants?=null
        constants = Constants()

        Glide.with(this)
            .load(constants?.URL_Image + getData?.gambar)
            .apply(RequestOptions().error(R.drawable.icon_nopic))
            .into(imgGambar)

        txtNamaProduct.text = getData?.namaProduct
        txtSubNamaProduct.text = getData?.namaProduct
        txtHargaProduct.formatPrice(getData?.hargaProduct.toString())
        txtSubHargaProduct.formatPrice(getData?.hargaProduct.toString())
        txtDiskon.formatPrice(getData?.diskon.toString())
        txtDeskripsi.text = getData?.deskripsi
        txtNilai.text = getData?.nilai

        btn_proses.setOnClickListener {
            val intent = Intent(this,CheckoutActivity::class.java)
            startActivity(intent)
        }
    }
}