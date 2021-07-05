package com.xiaoming.couroutine.server.respository

import com.xiaoming.couroutine.server.api.AppApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @Description:
 * @Author:         hayden
 * @CreateDate:     2021/4/15 11:37
 */
class AppRepository constructor(@JvmField val appApi: AppApi) {

    /**
     * 获取版本号
     * @param versionCode Long
     * @return ServiceResult<AppVersionVo>
     */
    suspend fun getAppVersion(versionCode: Long) = withContext(Dispatchers.IO) {
        appApi.getAppVersion(versionCode, 1)
    }
}