package com.khilman.secondretrofit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.khilman.secondretrofit.MVPDeleteUpdate.PresenterModel
import com.khilman.secondretrofit.MVPDeleteUpdate.PresenterUpdateHapus
import kotlinx.android.synthetic.main.activity_tambah.*

class TambahActivity : AppCompatActivity(), PresenterModel {
    override fun Hasil(result: Boolean, msg: String) {
        if (result){
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun Error(error: String) {
        Log.e("Error update", error.toString())
    }

    override fun DataSiswa(result: List<Datum>) {

    }

    var presenter : PresenterUpdateHapus? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)
        presenter = PresenterUpdateHapus(this)
        btnSubmit.setOnClickListener {
            var name = edtname.text.toString()
            var nis = edtnis.text.toString()
            if(nis.length <= 0) {
                nis = "00000"
            }
            presenter!!.Tambah(nis.toInt(), name)

        }
    }
}
