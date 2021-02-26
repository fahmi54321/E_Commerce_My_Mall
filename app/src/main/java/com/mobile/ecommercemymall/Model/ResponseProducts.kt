package com.mobile.ecommercemymall.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseProducts(

	@field:SerializedName("result")
	val result: List<ResultItemProducts?>? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class ResultItemProducts(

	@field:SerializedName("id_product")
	val idProduct: String? = null,

	@field:SerializedName("terjual")
	val terjual: String? = null,

	@field:SerializedName("nilai")
	val nilai: String? = null,

	@field:SerializedName("nama_product")
	val namaProduct: String? = null,

	@field:SerializedName("harga_product")
	val hargaProduct: String? = null,

	@field:SerializedName("deskripsi")
	val deskripsi: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("diskon")
	val diskon: String? = null
) : Parcelable
