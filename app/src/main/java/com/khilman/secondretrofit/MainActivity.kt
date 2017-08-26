package com.khilman.secondretrofit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.khilman.secondretrofit.MVPDeleteUpdate.PresenterMain
import com.khilman.secondretrofit.MVPDeleteUpdate.PresenterModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PresenterModel {
    override fun Hasil(result: Boolean, msg: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun DataSiswa(result: List<Datum>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var adapter = Custom(this@MainActivity, result)
        var linear = LinearLayoutManager(applicationContext)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = linear
    }

    var presenter : PresenterMain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterMain(this, this@MainActivity)
        presenter?.Tampil()
        //

        img2.setOnClickListener {
            startActivity(Intent(applicationContext, TambahActivity::class.java))
        }

    }
}
