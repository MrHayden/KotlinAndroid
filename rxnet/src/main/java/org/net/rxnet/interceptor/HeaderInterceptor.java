package org.net.rxnet.interceptor;

import android.text.TextUtils;

import org.net.rxnet.RxNet;
import org.net.rxnet.model.HttpHeaders;
import org.net.rxnet.utils.RxNetLog;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * <p> 添加头部参数 </p>
 *
 * @author hayden
 * date 2017/12/7
 */
public class HeaderInterceptor implements Interceptor {

    private HttpHeaders mHttpHeaders;

    public HeaderInterceptor(HttpHeaders httpHeaders) {
        mHttpHeaders = httpHeaders;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String tokenStr = RxNet.get().getToken();
        RxNetLog.d("OKHttp-------X-Token：" + tokenStr);
        if (!TextUtils.isEmpty(tokenStr)) {
            builder.addHeader("X-Token", tokenStr);
        }

        if (mHttpHeaders == null || mHttpHeaders.isEmpty()) {
            return chain.proceed(builder.build());
        }
        for (Map.Entry<String, String> entry : mHttpHeaders.headersMap.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }

        return chain.proceed(builder.build());
    }
}
