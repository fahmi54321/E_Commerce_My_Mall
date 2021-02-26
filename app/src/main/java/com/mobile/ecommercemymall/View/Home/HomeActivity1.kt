package com.mobile.ecommercemymall.View.Home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobile.ecommercemymall.Adapter.ProductAdapter
import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.DetailsMenu.DetailsMenuActivity1
import com.mobile.ecommercemymall.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_home1.*

class HomeActivity1 : AppCompatActivity() {

    lateinit var viewModel:ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        pengamatan()
        viewModel.getProduct()

        btnAll.setOnClickListener {
            changeIcon(btnAll,R.drawable.btn_primary)
            changeIcon(btnElectronic,R.drawable.btn_secondary)
            changeIcon(btnFood,R.drawable.btn_secondary)
            changeIcon(btnSmartphone,R.drawable.btn_secondary)
        }
        btnElectronic.setOnClickListener {
            changeIcon(btnAll,R.drawable.btn_secondary)
            changeIcon(btnElectronic,R.drawable.btn_primary)
            changeIcon(btnFood,R.drawable.btn_secondary)
            changeIcon(btnSmartphone,R.drawable.btn_secondary)
        }
        btnFood.setOnClickListener {
            changeIcon(btnAll,R.drawable.btn_secondary)
            changeIcon(btnElectronic,R.drawable.btn_secondary)
            changeIcon(btnFood,R.drawable.btn_primary)
            changeIcon(btnSmartphone,R.drawable.btn_secondary)
        }
        btnSmartphone.setOnClickListener {
            changeIcon(btnAll,R.drawable.btn_secondary)
            changeIcon(btnElectronic,R.drawable.btn_secondary)
            changeIcon(btnFood,R.drawable.btn_secondary)
            changeIcon(btnSmartphone,R.drawable.btn_primary)
        }
    }

    private fun pengamatan() {
        viewModel.responProducts.observe(this, Observer { responseProducts(it) })
        viewModel.errorProducts.observe(this, Observer { errorProducts(it) })
        viewModel.showLoadingProduct.observe(this, Observer { showLoadingProduct(it) })
    }

    private fun showLoadingProduct(it: Boolean?) {
        if (it==true){
            progressBarHome1.visibility = View.VISIBLE
        }
        if (it==false){
            progressBarHome1.visibility = View.GONE
        }
    }

    private fun errorProducts(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun responseProducts(it: ResponseProducts?) {
        var productAdapter = ProductAdapter(it?.result, object : ProductAdapter.onClickListener {
            override fun detail(item: ResultItemProducts?) {
                val intent = Intent(applicationContext, DetailsMenuActivity1::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }

        })

        rv_home_1.adapter = productAdapter
    }

    private fun changeIcon(button: Button, drawable: Int) {
        button.setBackgroundResource(drawable)
    }
}