package com.khilman.secondretrofit

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Rizal Hilman on 23/08/17.
 * rizal.drawrs@gmail.com
 * fb.me/rizal.ofdraw
 */
class Custom : RecyclerView.Adapter<Custom.MyHolder> {


    var c : Activity? = null
    var data2 : List<Datum>? = null

    constructor(arg: Activity, data: List<Datum>?){
        this.c = arg
        this.data2 = data
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var listname : TextView?  = itemView?.findViewById(R.id.listname)
        var listnis : TextView?  = itemView?.findViewById(R.id.listnis)
        var lisstatus : TextView? = itemView?.findViewById(R.id.liststatus)
        var siswa_id : Int? = null
        var linkupdate : TextView?  = itemView?.findViewById(R.id.linkupdate)
    }

    override fun getItemCount(): Int {
        return data2?.size!!
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.listname!!.text = data2?.get(position)!!.nama
        holder?.listnis!!.text = data2?.get(position)!!.nis.toString()
        // logic buat status siswa
        var statusSiswa : String = "Tidak aman"
        if (data2?.get(position)?.status.toString().equals("1")){
            statusSiswa = "Aman"
        }
        holder?.lisstatus?.text = statusSiswa

        holder?.linkupdate!!.setOnClickListener {
            var intent = Intent(c, UpdateDeleteActivity::class.java)
            intent?.putExtra("id", data2?.get(position)?.id)
            intent?.putExtra("nm", data2?.get(position)?.nama)
            intent?.putExtra("ns", data2?.get(position)?.nis)
            intent?.putExtra("ls", data2?.get(position)?.status)
            c?.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var view = LayoutInflater.from(c).inflate(R.layout.custom_list, parent, false)

        return MyHolder(view)
    }


}