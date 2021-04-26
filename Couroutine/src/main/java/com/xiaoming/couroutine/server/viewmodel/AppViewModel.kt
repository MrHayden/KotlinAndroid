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

    fun getAppVersion(versionCode: Long): LiveData<ServiceResult<AppVersionVo>?> {
        val mLiveData = MutableLiveData<ServiceResult<AppVersionVo>?>()
        requestData(onBlock = {
            appRepository.getAppVersion(versionCode)
        }, onSucceed = {
            mLiveData.value = it
        }, onFailed = {
            mLiveData.value = ServiceResult.throwableError(it)
        })
        return mLiveData

//        return liveData {
//            requestData(onBlock = {
//                appRepository.getAppVersion(versionCode)
//            }, onSucceed = {
//                emit(it)
//            }, onFailed = {
//                emit(ServiceResult.throwableError(it))
//            })
//        }
    }

}