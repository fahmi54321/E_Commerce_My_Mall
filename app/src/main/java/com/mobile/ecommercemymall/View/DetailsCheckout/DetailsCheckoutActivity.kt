package com.mobile.ecommercemymall.View.DetailsCheckout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.ecommercemymall.Adapter.CheckoutAdapter
import com.mobile.ecommercemymall.Adapter.DetailsCheckoutAdapter
import com.mobile.ecommercemymall.Adapter.ProductAdapter2
import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.DetailsMenu.DetailsMenuActivity1
import com.mobile.ecommercemymall.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_details_checkout.*

class DetailsCheckoutActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var viewModel2: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_checkout)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        viewModel2 = ViewModelProviders.of(this).get(ViewModel::class.java)
        pengamatan()
        viewModel.getProduct()
        viewModel2.getProduct()


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

        var checkoutAdapter = DetailsCheckoutAdapter(it?.result, object : DetailsCheckoutAdapter.onClickListener {
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

        var checkoutAdapter = DetailsCheckoutAdapter(it?.result, object : DetailsCheckoutAdapter.onClickListener {
            override fun detail(item: ResultItemProducts?) {
                Toast.makeText(applicationContext, item?.namaProduct, Toast.LENGTH_SHORT).show()
            }
        })

        rv_checkout_2.adapter = checkoutAdapter
    }
}