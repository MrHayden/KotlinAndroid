package com.xiaoming.couroutine.server.viewmodel

import androidx.lifecycle.ViewModel
import com.xiaoming.couroutine.server.respository.AppRepository

/**
 *
 * @Description:
 * @Author:         hayden
 * @CreateDate:     2021/4/15 11:36
 */
class AppViewModel constructor(private val appRepository: AppRepository) : ViewModel() {

    suspend fun getAppVersion(versionCode: Long) = appRepository.getAppVersion(versionCode)

}