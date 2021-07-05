package com.xiaoming.couroutine

import android.app.Application
import android.os.Build
import okhttp3.internal.tls.OkHostnameVerifier
import org.net.rxnet.BuildConfig
import org.net.rxnet.RxNet
import org.net.rxnet.model.HttpParams

/**
 *
 * @Description:
 * @Author:         hayden
 * @CreateDate:     2021/4/15 11:15
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initRxNet()
    }


    private fun initRxNet() {
        val httpParams = HttpParams()
        httpParams.put("os", "android")
        httpParams.put("osVersion", Build.VERSION.RELEASE)
        RxNet.init(this)
            .debug(BuildConfig.DEBUG)
            .setConnectTimeout(15_000)
            .setReadTimeout(10_000)
            .setWriteTimeout(10_000)
            .setBaseUrl(Constants.BASE_URL)
            .setHttpParams(httpParams)
            .hostnameVerifier(OkHostnameVerifier)
            .build()


    }
}