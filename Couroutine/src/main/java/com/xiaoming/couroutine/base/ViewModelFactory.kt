package com.xiaoming.couroutine.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xiaoming.couroutine.server.viewmodel.AppViewModel

/**
 * @Description:    model 工厂类
 * @Author:         hayden
 * @CreateDate:     2021/7/2 10:39
 */
class ViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        (when {
            modelClass.isAssignableFrom(AppViewModel::class.java) -> {
                val appRepo = ServiceLocator.instance(context).getAppRepository()
                AppViewModel(appRepo)
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }) as T


    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE
                        ?: ViewModelFactory(
                            application/*,*/
                            /*  Injection.provideTasksRepository(application.applicationContext)*/
                        )
                            .also { INSTANCE = it }
                }


        @VisibleForTesting
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}