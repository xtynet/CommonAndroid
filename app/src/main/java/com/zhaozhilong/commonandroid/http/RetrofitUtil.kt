package com.zhaozhilong.commonandroid.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitUtil {

    fun service():Service{

        val retrofit = Retrofit.Builder()
            .baseUrl("http://web.juhe.cn:8080/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: Service = retrofit.create<Service>(Service::class.java)

        return service
    }

}