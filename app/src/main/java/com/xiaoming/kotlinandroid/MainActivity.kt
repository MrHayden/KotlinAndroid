package com.xiaoming.kotlinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testCoroutines()
    }


    fun testCoroutines() = run {
        GlobalScope.launch(Dispatchers.Main) {
            for (k in 1..10) {
                println("------------I'm not blocked $k")
            }
        }
    }
}
