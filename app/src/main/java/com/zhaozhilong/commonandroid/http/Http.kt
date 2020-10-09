package com.zhaozhilong.commonandroid.http

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.zhaozhilong.commonandroid.bean.XingZuo
import com.zhaozhilong.commonandroid.callback.DoHttp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Http {

    fun <T> get(lifecycleScope:LifecycleCoroutineScope,doHttp:DoHttp<T>){

        lifecycleScope.launch(Dispatchers.IO) {

            var result=doHttp.doNet()
            lifecycleScope.launch(Dispatchers.Main) {
                doHttp.doUi(result as T)
            }

        }

    }

}