package com.xiaoming.couroutine

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL


const val URL_IMG = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1603074642&di=2daa65bfac02046b994cfb4dddd52f53&src=http://a0.att.hudong.com/56/12/01300000164151121576126282411.jpg"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.Main).launch {
            val bitmap = loadImage(URL_IMG)
            imageView.setImageBitmap(bitmap)
        }
    }

    /**
     * 加载图片
     * @param url String
     * @return (android.graphics.Bitmap..android.graphics.Bitmap?)
     */
    private suspend fun loadImage(url: String) = withContext(Dispatchers.IO) {
        val httpURLConnection = (URL(url).openConnection() as HttpURLConnection)
        httpURLConnection.apply {
            requestMethod = "GET"
            connectTimeout = 6000
        }.connect()
        val inputStream = httpURLConnection.inputStream
        val bitmap = BitmapFactory.decodeStream(inputStream)
        inputStream.close()
        bitmap
    }
}
