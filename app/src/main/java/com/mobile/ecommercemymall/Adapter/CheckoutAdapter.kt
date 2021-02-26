package com.mobile.ecommercemymall.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mobile.ecommercemymall.Helpers.formatPrice
import com.mobile.ecommercemymall.Model.ResultItemProducts
import com.mobile.ecommercemymall.Model.ResultItemUsers
import com.mobile.ecommercemymall.R
import com.mobile.inkadosumbar.Constants.Constants

class CheckoutAdapter(
    var data:List<ResultItemProducts?>?,
    var itemClick:onClickListener
):RecyclerView.Adapter<CheckoutAdapter.ProductMainHolder>() {

    class ProductMainHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var namaProduct = itemView.findViewById<TextView>(R.id.txtNamaProduct)
        var gambar = itemView.findViewById<ImageView>(R.id.imgGambar)
        var deskripsi = itemView.findViewById<TextView>(R.id.txtDeskripsi)
        var harga = itemView.findViewById<TextView>(R.id.txtHarga)
//        var imgCheck = itemView.findViewById<ImageView>(R.id.img_check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductMainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_checkout, parent, false)
        return ProductMainHolder(view)
    }

    override fun onBindViewHolder(holder: ProductMainHolder, position: Int) {
        val item = data?.get(position)

        var constants: Constants?=null
        constants = Constants()

        Glide.with(holder.itemView.context)
            .load(constants?.URL_Image + data?.get(position)?.gambar)
            .apply(RequestOptions().error(R.drawable.icon_nopic))
            .into(holder.gambar)

        holder.namaProduct.text = item?.namaProduct
        holder.harga.formatPrice(item?.hargaProduct.toString())

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }
//        holder.imgCheck.setOnClickListener {
//            itemClick.check()
//        }

    }

    override fun getItemCount(): Int=data?.size?:0

    interface onClickListener {
        fun detail(item: ResultItemProducts?)
    }
}