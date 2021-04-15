package com.xiaoming.couroutine.server.api

import com.xiaoming.couroutine.server.ServiceResult
import com.xiaoming.couroutine.server.vo.AppVersionVo
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @Description:
 * @Author:         hayden
 * @CreateDate:     2021/4/15 11:18
 */
interface AppApi {

    /**
     *@param versionType 1-安卓,2-iOS
     */
    @GET("/appVersion/checkAppVersionIsUptoDate")
    suspend fun getAppVersion(
        @Query("versionNumber") versionNumber: Long,
        @Query("versionType") versionType: Int
    ): ServiceResult<AppVersionVo>
}