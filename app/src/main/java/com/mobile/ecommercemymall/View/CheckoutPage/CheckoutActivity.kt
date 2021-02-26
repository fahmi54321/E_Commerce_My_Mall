package com.mobile.ecommercemymall.View.CheckoutPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobile.ecommercemymall.Adapter.CheckoutAdapter
import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.AddressMenu.AddressMenuActivity
import com.mobile.ecommercemymall.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var viewModel2: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        viewModel2 = ViewModelProviders.of(this).get(ViewModel::class.java)
        pengamatan()
        viewModel.getProduct()
        viewModel2.getProduct()

        btn_buy_now.setOnClickListener {
            val intent = Intent(this,AddressMenuActivity::class.java)
            startActivity(intent)
        }

    }

    private fun pengamatan() {
        viewModel.responProducts.observe(this, Observer { responseProducts(it) })
        viewModel.errorProducts.observe(this, Observer { errorProducts(it) })
        viewModel.showLoadingProduct.observe(this, Observer { showLoadingProduct(it) })

        viewModel2.responProducts.observe(this, Observer { responseProducts2(it) })
        viewModel2.errorProducts.observe(this, Observer { errorProducts2(it) })
        viewModel2.showLoadingProduct.observe(this, Observer { showLoadingProduct2(it) })
    }

    private fun showLoadingProduct(it: Boolean?) {
        if (it==true){
            progressBarCheckout.visibility = View.VISIBLE
        }
        if (it==false){
            progressBarCheckout.visibility = View.GONE
        }
    }

    private fun errorProducts(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun responseProducts(it: ResponseProducts?) {

        var checkoutAdapter = CheckoutAdapter(it?.result, object : CheckoutAdapter.onClickListener {
            override fun detail(item: ResultItemProducts?) {

            }
        })

        rv_checkout_1.adapter = checkoutAdapter
    }


    private fun showLoadingProduct2(it: Boolean?) {
        if (it==true){
            progressBarCheckout.visibility = View.VISIBLE
        }
        if (it==false){
            progressBarCheckout.visibility = View.GONE
        }
    }

    private fun errorProducts2(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun responseProducts2(it: ResponseProducts?) {

        var checkoutAdapter = CheckoutAdapter(it?.result, object : CheckoutAdapter.onClickListener {
            override fun detail(item: ResultItemProducts?) {
                Toast.makeText(applicationContext, item?.namaProduct, Toast.LENGTH_SHORT).show()
            }
        })

        rv_checkout_2.adapter = checkoutAdapter
    }

    private fun changeIcon(img: ImageView, drawable: Int) {
        img.setImageResource(drawable)
    }
}