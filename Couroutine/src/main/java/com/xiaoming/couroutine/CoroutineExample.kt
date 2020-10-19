package com.xiaoming.couroutine

import android.graphics.BitmapFactory
import android.widget.ImageView
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

/**
 * author: xxm
 * created on: 2020/8/4 16:10
 * description:协程测试
 */
class CoroutineExample {

    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {
//            testGlobalScopeLaunch()

//            testRunBlocking()
            runBlocking {
//                launch {
//                    testJob()
//                }
                testJob()
            }

        }

        private fun testGlobalScopeLaunch() {
            GlobalScope.launch {
                delay(1000L)
                println("World！")
            }
            println("Hello，")

            //阻塞主线程
            runBlocking {
                delay(1200L)
            }
        }

        private fun testRunBlocking() = runBlocking {
            GlobalScope.launch {
                delay(1000L)
                println("World！")
            }
            println("Hello，")
            delay(1200L)
        }

        private suspend fun testJob() {
            val job = GlobalScope.launch {
                delay(1000L)
                println("World！")
            }
            println("Hello，")
            job.join()//等待直到子线程结束
        }

    }
}