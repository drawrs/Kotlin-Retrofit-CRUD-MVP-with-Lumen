package com.khilman.secondretrofit.MVPDeleteUpdate

import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import com.khilman.secondretrofit.InitRetrofit
import com.khilman.secondretrofit.MainActivity
import com.khilman.secondretrofit.R
import com.khilman.secondretrofit.ResponseData
import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Response

/**
 * Created by Rizal Hilman on 23/08/17.
 * rizal.drawrs@gmail.com
 * fb.me/rizal.ofdraw
 */

class PresenterMain {
    var presenterView : PresenterModel ? = null
    // menampung contect pada MainActivity
    var context : MainActivity ? = null

    constructor(presenterView: PresenterModel?, mainActivity: MainActivity) {
        this.context = mainActivity
        this.presenterView = presenterView
    }
    fun Tampil() {

        var getInit = InitRetrofit().getInitInstance()
        // get request
        var request = getInit.request_getdata()
        // get response
        request.enqueue(object : retrofit2.Callback<ResponseData> {
            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Log.d("response", t?.toString())
            }

            override fun onResponse(call: Call<ResponseData>?, response: Response<ResponseData>?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                if (response != null){
                    var result = response.body()?.data!!
                    // cari loadernya terus hide
                    var loader = context?.findViewById(R.id.loader) as RelativeLayout?
                    loader?.visibility = View.GONE

                    presenterView?.DataSiswa(result)
                }
            }

        })

    }
}
