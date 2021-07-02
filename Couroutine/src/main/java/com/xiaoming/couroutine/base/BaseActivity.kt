package com.xiaoming.couroutine.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xiaoming.couroutine.R

/**
 *
 * @Description:
 * @Author:         hayden
 * @CreateDate:     2021/4/15 11:44
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getCustomerLayout())
    }

    open fun getCustomerLayout(): Int {
        return R.layout.activity_main
    }

    fun <T : ViewModel?> getViewModel(clazz: Class<T>): T {
        return ViewModelProvider(this,ViewModelFactory.getInstance(application)).get(clazz)
    }

}