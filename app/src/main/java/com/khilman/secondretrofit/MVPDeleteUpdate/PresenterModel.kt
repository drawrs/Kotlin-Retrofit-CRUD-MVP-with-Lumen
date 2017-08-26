package com.khilman.secondretrofit.MVPDeleteUpdate

import com.khilman.secondretrofit.Datum

/**
 * Created by Rizal Hilman on 23/08/17.
 * rizal.drawrs@gmail.com
 * fb.me/rizal.ofdraw
 */
interface PresenterModel {
    fun Hasil(result: Boolean, msg : String)
    fun Error(error: String)
    fun DataSiswa(result: List<Datum>)
}