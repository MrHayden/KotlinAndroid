package org.net.rxnet.utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @Description:
 * @Author: hayden
 * @CreateDate: 2021/3/6 12:08
 */
public class HttpBodyUtil {

    public static RequestBody createRequestBody(String jsonObjectStr){
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObjectStr);
    }
}
