package com.xiaoming.couroutine.activity

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import com.xiaoming.couroutine.R
import com.xiaoming.couroutine.base.BaseActivity
import com.xiaoming.couroutine.server.api.AppApi
import com.xiaoming.couroutine.server.respository.AppRepository
import com.xiaoming.couroutine.server.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import org.net.rxnet.RxNet
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : BaseActivity(), CoroutineScope by MainScope() {

    private lateinit var appViewModel: AppViewModel

    override fun getCustomerLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appViewModel = AppViewModel(AppRepository(RxNet.create(AppApi::class.java)))

        btn_send_request.setOnClickListener {
            //        CoroutineScope(Dispatchers.Main).launch {
//            val bitmap = loadImage(Constants.URL_IMG)
//            imageView.setImageBitmap(bitmap)
//        }

            requestAppVersion()
        }

    }

    private fun requestAppVersion() {
        launch {
            val resultData = withContext(Dispatchers.IO) {
                appViewModel.getAppVersion(21041001)
            }
            Log.e("http", "返回值：$resultData")
            if (resultData.isSuccess()) {
                tv_content.text = resultData.message
            }
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

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}
