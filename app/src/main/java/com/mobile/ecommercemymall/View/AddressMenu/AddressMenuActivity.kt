package com.mobile.ecommercemymall.View.AddressMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobile.ecommercemymall.Adapter.AddressAdapter
import com.mobile.ecommercemymall.Adapter.ProductAdapter
import com.mobile.ecommercemymall.Model.ResponseUsers
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.Model.ResultItemUsers
import com.mobile.ecommercemymall.R
import com.mobile.ecommercemymall.View.Delivery.DeliveryActivity
import com.mobile.ecommercemymall.View.DetailsMenu.DetailsMenuActivity1
import com.mobile.ecommercemymall.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_address_menu.*
import kotlinx.android.synthetic.main.activity_home1.*

class AddressMenuActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel
    var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_menu)

        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)
        pengamatan()
        viewModel.getUsers()

        btn_save_address.setOnClickListener {
            val intent = Intent(this,DeliveryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun pengamatan() {
        viewModel.responUsers.observe(this, Observer { responUsers(it) })
        viewModel.errorUsers.observe(this, Observer { errorUsers(it) })
        viewModel.showLoadingUsers.observe(this, Observer { showLoadingUsers(it) })
    }

    private fun showLoadingUsers(it: Boolean?) {
        if (it==true){
            progressAddress.visibility = View.VISIBLE
        }
        if (it==false){
            progressAddress.visibility = View.GONE
        }
    }

    private fun errorUsers(it: Throwable?) {
        Toast.makeText(applicationContext, it?.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    private fun responUsers(it: ResponseUsers?) {
        var addressAdapter = AddressAdapter(it?.result, object : AddressAdapter.onClickListener {
            override fun detail(item: ResultItemUsers?) {
            }

            override fun hitung(cout: Int) {
                when(cout){
                    1->{
                        changeIcon(btn_save_address,R.drawable.bg_btn_address_pimary)
                    }
                    0->{
                        changeIcon(btn_save_address,R.drawable.bg_btn_address_secondary)
                    }
                }
            }

        })

        rv_address.adapter = addressAdapter
    }

    private fun changeIcon(button: Button, drawable: Int) {
        button.setBackgroundResource(drawable)
    }
}