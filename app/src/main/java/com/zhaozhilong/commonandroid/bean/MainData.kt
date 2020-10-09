package com.zhaozhilong.commonandroid.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * 首页数据
 */
class MainData(var text:MutableLiveData<String>): BaseObservable() {
}