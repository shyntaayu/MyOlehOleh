package com.example.atry

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import com.squareup.picasso.Picasso

class Adapter(val mCtx:Context, val layoutResId:Int, val list:List<Users>): ArrayAdapter<Users>(mCtx,layoutResId,list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutResId,null)

        val textNama = view.findViewById<TextView>(R.id.textNama)
        val textStatus = view.findViewById<TextView>(R.id.textStatus)
        val ivProduk = view.findViewById<ImageView>(R.id.ivProduk)
        val tvRating = view.findViewById<TextView>(R.id.textRating)


        val user = list[position]

        textNama.text = user.nama
        textStatus.text = user.status
        tvRating.text = user.rating.toString()
        user.urlImage?.let { Picasso.get().load(user.urlImage).into(ivProduk) }

        return view;
    }
}