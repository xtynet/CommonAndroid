package com.zhaozhilong.commonandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.zhaozhilong.commonandroid.R
import com.zhaozhilong.commonandroid.bean.MainData
import com.zhaozhilong.commonandroid.bean.XingZuo
import com.zhaozhilong.commonandroid.callback.DoHttp
import com.zhaozhilong.commonandroid.databinding.ActivityMainBinding
import com.zhaozhilong.commonandroid.http.Http
import com.zhaozhilong.commonandroid.responstory.TestResponstory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : BaseActivity() {
    lateinit var data:MainData
    lateinit var testResponstory:TestResponstory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

       var binding: ActivityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        binding.setLifecycleOwner(this)

        var liveData=MutableLiveData<String>()

        data=MainData(liveData)

        data.text.value=UUID.randomUUID().toString()

        binding.mainData=data

        Http().get(lifecycleScope,object :DoHttp<XingZuo>{
            override suspend fun doNet(): Any? {
                return testResponstory.test()
            }

            override fun doUi(result: XingZuo?) {
                show(result.toString())
            }

        })
    }

    private fun initData() {
        testResponstory= TestResponstory()
    }

    @MainThread
    fun update(s:String){


    }

    suspend fun delay():String{

        Thread.sleep(3000)
        return UUID.randomUUID().toString()+"<--"
    }
}