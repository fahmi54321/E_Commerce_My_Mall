package com.mobile.ecommercemymall


import android.widget.TextView
import com.google.gson.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object Helpers {

    fun TextView.formatPrice(value:String){
        this.text = getCurrencyRp(java.lang.Double.parseDouble(value))
    }

    fun getCurrencyRp(price:Double):String{
        val format = DecimalFormat("#,###,###")
        return "Rp "+format.format(price).replace(",".toRegex(),".")
    }
}