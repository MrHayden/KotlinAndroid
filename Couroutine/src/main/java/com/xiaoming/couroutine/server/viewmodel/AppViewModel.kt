package com.xiaoming.couroutine.server.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xiaoming.couroutine.base.BaseViewModel
import com.xiaoming.couroutine.server.ServiceResult
import com.xiaoming.couroutine.server.respository.AppRepository
import com.xiaoming.couroutine.server.vo.AppVersionVo

/**
 *
 * @Description:
 * @Author:         hayden
 * @CreateDate:     2021/4/15 11:36
 */
class AppViewModel constructor(private val appRepository: AppRepository) : BaseViewModel() {

//    private val mCoroutineScope: CoroutineScope =
//        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    val appVersionLiveData = MutableLiveData<ServiceResult<AppVersionVo>?>()
    fun getAppVersion(versionCode: Long) {
        requestData(onBlock = {
            appRepository.getAppVersion(versionCode)
        }, onSucceed = {
            appVersionLiveData.value = it
        }, onFailed = {
            appVersionLiveData.value = ServiceResult.throwableError(it)
        })

        //todo  livedata没有在页面关闭时自动取消任务
//        return liveData(context = mCoroutineScope.coroutineContext) {
//            kotlin.runCatching {
//                appRepository.getAppVersion(versionCode)
//            }.onSuccess {
//                emit(it)
//            }.onFailure {
//                emit(ServiceResult.throwableError(it))
//            }
//        }
    }

//    override fun onCleared() {
//        super.onCleared()
//        mCoroutineScope.cancel()
//    }

}