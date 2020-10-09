package com.zhaozhilong.commonandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.zhaozhilong.commonandroid.bean.XingZuo
import com.zhaozhilong.commonandroid.callback.DoHttp
import com.zhaozhilong.commonandroid.http.Http
import com.zhaozhilong.commonandroid.responstory.TestResponstory

class HomeFragment : Basefragment() {

    lateinit var testResponstory:TestResponstory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    private fun initData() {
        testResponstory= TestResponstory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Http().get(lifecycleScope,object :DoHttp<XingZuo>{
            override suspend fun doNet(): Any? {
                return testResponstory.test()
            }

            override fun doUi(result: XingZuo?) {
                show(result.toString())
            }

        })

    }

}