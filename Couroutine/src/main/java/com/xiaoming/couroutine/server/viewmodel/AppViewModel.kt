package com.xiaoming.couroutine.server.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
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

    val appVersionLiveData = MutableLiveData<ServiceResult<AppVersionVo>?>()
    fun getAppVersion(versionCode: Long) {
        requestData(onBlock = {
            appRepository.getAppVersion(versionCode)
        }, onSucceed = {
            appVersionLiveData.value = it
        }, onFailed = {
            appVersionLiveData.value = ServiceResult.throwableError(it)
        })
    }

//    fun getAppVersion(versionCode: Long) =
//        liveData(viewModelScope.coroutineContext) {
//            kotlin.runCatching {
//                appRepository.getAppVersion(versionCode)
//            }.onSuccess {
//                emit(it)
//            }.onFailure {
//                emit(ServiceResult.throwableError(it))
//            }
//        }
}