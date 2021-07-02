package com.xiaoming.couroutine.activity

import android.content.Intent
import android.os.Bundle
import com.xiaoming.couroutine.R
import com.xiaoming.couroutine.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun getCustomerLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_start.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

    }


}
