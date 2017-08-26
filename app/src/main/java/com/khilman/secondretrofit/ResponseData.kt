package com.khilman.secondretrofit

import com.google.gson.annotations.SerializedName


class ResponseData {

    @SerializedName("data")
    var data: List<Datum>? = null

}
