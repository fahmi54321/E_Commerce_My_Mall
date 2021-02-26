package com.mobile.ecommercemymall.View.Home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.ViewModel.ViewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.ecommercemymall.Adapter.ProductAdapter
import com.mobile.ecommercemymall.Adapter.ProductAdapter2
import com.mobile.ecommercemymall.Model.ResponseProducts
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.View.DetailsMenu.DetailsMenuActivity1
import kotlinx.android.synthetic.main.activity_home2.*

class HomeActivity2 : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    lateinit var viewModel2: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        viewModel2 = ViewModelProviders.of(this).get(ViewModel::class.java)
        pengamatan()
        viewModel.getProduct()
        viewModel2.getProduct()

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

        viewModel2.responProducts.observe(this, Observer { responseProducts2(it) })
        viewModel2.errorProducts.observe(this, Observer { errorProducts2(it) })
        viewModel2.showLoadingProduct.observe(this, Observer { showLoadingProduct2(it) })
    }

    private fun showLoadingProduct(it: Boolean?) {
        if (it==true){
            progressBarHome2.visibility = View.VISIBLE
        }
        if (it==false){
            progressBarHome2.visibility = View.GONE
        }
    }

    private fun errorProducts(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun responseProducts(it: ResponseProducts?) {

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        rv_home_2_1.layoutManager = layoutManager

        var productAdapter = ProductAdapter2(it?.result, object : ProductAdapter2.onClickListener {
            override fun detail(item: ResultItemProducts?) {
                val intent = Intent(applicationContext, DetailsMenuActivity1::class.java)
                intent.putExtra("data",item)
                startActivity(intent)
            }
        })

        rv_home_2_1.adapter = productAdapter
    }


    private fun showLoadingProduct2(it: Boolean?) {
        if (it==true){
            progressBarHome2.visibility = View.VISIBLE
        }
        if (it==false){
            progressBarHome2.visibility = View.GONE
        }
    }

    private fun errorProducts2(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun responseProducts2(it: ResponseProducts?) {

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)

        rv_home_2_2.layoutManager = layoutManager

        var productAdapter = ProductAdapter2(it?.result, object : ProductAdapter2.onClickListener {
            override fun detail(item: ResultItemProducts?) {
                Toast.makeText(applicationContext, item?.namaProduct, Toast.LENGTH_SHORT).show()
            }
        })

        rv_home_2_2.adapter = productAdapter
    }

    private fun changeIcon(button: Button, drawable: Int) {
        button.setBackgroundResource(drawable)
    }
}