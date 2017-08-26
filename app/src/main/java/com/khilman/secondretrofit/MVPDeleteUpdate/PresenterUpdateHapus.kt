package com.khilman.secondretrofit.MVPDeleteUpdate

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.khilman.secondretrofit.InitRetrofit
import com.khilman.secondretrofit.ResponseInsert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Rizal Hilman on 23/08/17.
 * rizal.drawrs@gmail.com
 * fb.me/rizal.ofdraw
 */
class PresenterUpdateHapus {
    var presenterView : PresenterModel? = null
    var c : Context? = null

    constructor(presenterView: PresenterModel?) {
        this.presenterView = presenterView
    }
    fun Hapus(id: String, applicationContext: Context){
        this.c = applicationContext
        var getInit = InitRetrofit().getInitInstance()
        // get request
        var request = getInit.request_delete(id)
        // get response
//                var progress = ProgressDialog(applicationContext)
//                progress.setMessage("Loading")
//                progress.show()

        request.enqueue(object : retrofit2.Callback<ResponseInsert> {
            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
                //progress.dismiss()
                Log.d("response ", response?.message())
                if (response != null){
                    if(response.isSuccessful && response.body()?.status!!){
                        var result = response.body()?.status
                        var msg = response.body()?.msg
                        Toast.makeText(c, "Berhasil dihapus !", Toast.LENGTH_SHORT).show()
                        presenterView?.Hasil(result!!, msg!!)
                    }
                }
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                //progress.dismiss()
                Log.d("response ", t?.toString())
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
    fun Update(id: String, nis : String, nama: String){
        var getInit = InitRetrofit().getInitInstance()
        var request = getInit.request_update(id, nis, nama)

        request.enqueue(object : Callback<ResponseInsert> {
            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                Log.d("response update ", t?.toString())
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
                Log.d("response Update", response?.message())
                if (response != null){
                    if (response.isSuccessful && response.body()?.status!!){
                        var result = response.body()?.status
                        var msg = response.body()?.msg

                        presenterView?.Hasil(result!!, msg!!)
                    }
                }
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
    fun Tambah(nis : Int, nama: String){
        var getInit = InitRetrofit().getInitInstance()
        var request = getInit.request_insert(nis, nama, 1)

        request.enqueue(object : Callback<ResponseInsert> {
            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                Log.d("response update ", t?.toString())
            }

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
                Log.d("response Update", response?.message())
                if (response != null){
                    if (response.isSuccessful && response.body()?.status!!){
                        var result = response.body()?.status
                        var msg = response.body()?.msg

                        presenterView?.Hasil(result!!, msg!!)
                    }
                }
            }

        })
    }
}