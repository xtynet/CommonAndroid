package com.zhaozhilong.commonandroid.http

import com.zhaozhilong.commonandroid.bean.XingZuo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("constellation/getAll")
    fun test(@Query("consName") consName:String,@Query("type")type:String,@Query("key")key:String): Call<XingZuo>

}