package com.zhaozhilong.commonandroid.fragment

import android.widget.Toast
import androidx.fragment.app.Fragment

open class Basefragment: Fragment() {

    fun show(text:String){

        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()

    }

}