package com.zhaozhilong.commonandroid.callback

interface DoHttp<T> {

    suspend fun doNet():Any?

    fun doUi(result: T?)

}