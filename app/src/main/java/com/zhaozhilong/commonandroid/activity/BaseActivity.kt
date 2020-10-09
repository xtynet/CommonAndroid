package com.zhaozhilong.commonandroid.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.zhaozhilong.commonandroid.callback.DoHttp
import com.zhaozhilong.commonandroid.responstory.TestResponstory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseActivity : AppCompatActivity() {

    fun show(text:String){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
    }


}