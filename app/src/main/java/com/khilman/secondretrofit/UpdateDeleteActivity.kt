package com.khilman.secondretrofit

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.Toast
import com.khilman.secondretrofit.MVPDeleteUpdate.PresenterModel
import com.khilman.secondretrofit.MVPDeleteUpdate.PresenterUpdateHapus
import kotlinx.android.synthetic.main.activity_update_delete.*

class UpdateDeleteActivity : AppCompatActivity(), PresenterModel {
    override fun DataSiswa(result: List<Datum>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    // deklarasi
    var id : Long? = null
    var nama : String? = null
    var nis : Long? = null
    var presenter : PresenterUpdateHapus? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        presenter = PresenterUpdateHapus(this)

        id = intent.getLongExtra("id", 0)
        nama = intent.getStringExtra("nm")
        nis = intent.getLongExtra("ns", 0)

        edtname.setText(nama)
        edtnis.setText(nis.toString())

        btnHapus.setOnClickListener {
            var dialog = AlertDialog.Builder(this@UpdateDeleteActivity)
            dialog.setMessage("Hapus data ini ?")
            dialog.setPositiveButton("ya", DialogInterface.OnClickListener { dialogInterface, i ->
                presenter!!.Hapus(id.toString(), this)
            })
            dialog.setNegativeButton("tidak", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            dialog.show()
        }

        btnUpdate.setOnClickListener {
            presenter!!.Update(id.toString(), edtnis.text.toString(), edtname.text.toString())
        }
        //edtname.text = Custom().data2.get(posisi).nama.toString()

    }
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

}
