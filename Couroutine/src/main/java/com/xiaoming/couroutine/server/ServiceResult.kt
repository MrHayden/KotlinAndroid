package com.xiaoming.couroutine.server

import android.text.TextUtils
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * <p> 服务端通用结果返回</p>
 * @author hayden
 *          date 2018/3/17
 */
data class ServiceResult<out T>(
    var code: Int? = 0,
    var message: String? = null,
    val data: T? = null
) {
    fun isSuccess(): Boolean {
        return code == SUCCESS
    }

    companion object {
        var SUCCESS = 200

        /** 没有网络  */
        val NOT_NET = 50010

        /**失败*/
        val FAIL = 100

        val OTHER = 0
        val CONN_ERROR: ServiceResult<Unit> = ServiceResult(message = "网络错误!")

        fun <T> success(data: T?) = ServiceResult(SUCCESS, "success", data)

        fun <T> error(code: Int?, message: String?) = ServiceResult<T>(code, message, null)

        fun <T> paramError(): ServiceResult<T> {
            return ServiceResult(message = "参数错误", data = null)
        }

        fun <T> noNetError(): ServiceResult<T> {
            return ServiceResult(message = "无网络，请检查网络连接", data = null, code = NOT_NET)
        }

        fun <T> otherError(error: String?): ServiceResult<T> {
//            return ServiceResult(message = error, data = null, code = OTHER)
            return ServiceResult(
                message = if (TextUtils.isEmpty(error)) "操作失败" else error,
                data = null,
                code = OTHER
            )
        }

        fun <T> throwableError(it: Throwable): ServiceResult<T> {
            if (it is UnknownHostException || it is ConnectException) {
                return noNetError()
            }
            if (it is HttpException && it.code() in (400..600)) {
                return ServiceResult(0, "服务器开小差了，请稍后再试")
            }
            return ServiceResult(0, it?.message)
        }
    }

}
