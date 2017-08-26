package com.khilman.secondretrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.sql.ClientInfoStatus

/**
 * Created by Rizal Hilman on 23/08/17.
 * rizal.drawrs@gmail.com
 * fb.me/rizal.ofdraw
 */
class InitRetrofit {
    fun getInitRetrofit(): Retrofit {
        // ganti ddengan uri api server kalian
        // contoh server lokal http://192.168.95.196/lumen-api24/public/
        return Retrofit.Builder().baseUrl("http://api.khilman.net/data-siswa-lumen/public/").addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getInitInstance(): ApiService {
        return getInitRetrofit().create(ApiService::class.java)
    }
}

interface ApiService {
    @GET("input-siswa")
    fun request_insert(
            @Query("nis") nis: Int,
            @Query("nama") nama: String,
            @Query("status") status: Int
    ): Call<ResponseInsert>

    @GET("get-siswa")
    fun request_getdata(): Call<ResponseData>

    @FormUrlEncoded
    @POST("update-siswa")
    fun request_update(@Field("id") id: String,
                       @Field("nis") nis: String,
                       @Field("nama") name: String): Call<ResponseInsert>

    @FormUrlEncoded
    @POST("delete-siswa")
    fun request_delete(@Field("id") id: String): Call<ResponseInsert>

//    @FormUrlEncoded
//    @POST("update-siswa")
//    fun request_update(@Field("id") id : String, @Field("nis") nis : String, @Field("nama") nama : String) : Call<ResponseInsert>
}
