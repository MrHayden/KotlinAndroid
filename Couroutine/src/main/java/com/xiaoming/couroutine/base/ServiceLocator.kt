package com.xiaoming.couroutine.base

import android.app.Application
import android.content.Context
import androidx.annotation.VisibleForTesting
import com.xiaoming.couroutine.server.api.AppApi
import com.xiaoming.couroutine.server.respository.AppRepository
import org.net.rxnet.RxNet

/**
 * @Description:    Super simplified service locator implementation to allow us to replace default implementations for testing
 * @Author:         hayden
 * @CreateDate:     2021/7/2 10:21
 */
interface ServiceLocator {
    companion object {
        private val LOCK = Any()
        private var instance: ServiceLocator? = null
        fun instance(context: Context): ServiceLocator {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = DefaultServiceLocator(
                        app = context.applicationContext as Application,
                        useInMemoryDb = false
                    )
                }
                return instance!!
            }
        }

        /**
         * Allows tests to replace the default implementations.
         */
        @VisibleForTesting
        fun swap(locator: ServiceLocator) {
            instance = locator
        }
    }


    fun getAppRepository(): AppRepository


}

/**
 * default implementation of ServiceLocator that uses production endpoints.
 */
//@Singleton
open class DefaultServiceLocator(val app: Application, val useInMemoryDb: Boolean) :
    ServiceLocator {

    private val appViewModelApi by lazy {
        RxNet.create(AppApi::class.java)
    }

    override fun getAppRepository(): AppRepository {
        return AppRepository(appViewModelApi)
    }


}