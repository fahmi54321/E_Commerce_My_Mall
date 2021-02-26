package com.mobile.ecommercemymall.Model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseUsers(

	@field:SerializedName("result")
	val result: List<ResultItemUsers?>? = null,

	@field:SerializedName("message")
	val message: String? = null
) : Parcelable

@Parcelize
data class ResultItemUsers(

	@field:SerializedName("thn_lahir")
	val thnLahir: String? = null,

	@field:SerializedName("email_address")
	val emailAddress: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("no_hp")
	val noHp: String? = null,

	@field:SerializedName("id_users")
	val idUsers: String? = null,

	@field:SerializedName("bln_lahir")
	val blnLahir: String? = null,

	@field:SerializedName("tgl_lahir")
	val tglLahir: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null
) : Parcelable
