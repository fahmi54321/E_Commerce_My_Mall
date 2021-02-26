package com.mobile.ecommercemymall.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
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

class AddressAdapter(
    var data:List<ResultItemUsers?>?,
    var itemClick:onClickListener
):RecyclerView.Adapter<AddressAdapter.ProductMainHolder>() {

    class ProductMainHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var nama = itemView.findViewById<TextView>(R.id.txtNama)
        var noHp = itemView.findViewById<TextView>(R.id.txtNoHp)
        var address = itemView.findViewById<TextView>(R.id.txtAlamat)
        var check = itemView.findViewById<CheckBox>(R.id.check)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductMainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        return ProductMainHolder(view)
    }

    override fun onBindViewHolder(holder: ProductMainHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.nama
        holder.noHp.text = item?.noHp
        holder.address.text = item?.alamat

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }

        holder.check.setOnClickListener {
            if (holder.check.isChecked){
                itemClick.hitung(1)
            }else{
                itemClick.hitung(0)
            }

        }
    }

    override fun getItemCount(): Int=data?.size?:0

    interface onClickListener {
        fun detail(item: ResultItemUsers?)
        fun hitung(cout:Int)
    }
}