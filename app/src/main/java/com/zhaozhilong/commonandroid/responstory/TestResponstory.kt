package com.zhaozhilong.commonandroid.responstory

import com.zhaozhilong.commonandroid.bean.XingZuo
import com.zhaozhilong.commonandroid.http.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestResponstory {

    suspend fun  test():XingZuo?{

        return RetrofitUtil.service().test("处女座","today","5528aa2a5dc58b3373349532f850f630").execute().body()
    }

}