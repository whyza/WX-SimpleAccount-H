package com.simpleaccount.util.imagesutil;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/4/20 16:13
 * @Version: 1.0
 */
public class QiniuFileUploadUtil {
    public static String ACCESS_KEY = "aAqIfnjv3O8eR0U3xmWKYNkB22KMkufQo6YBdTLf";
    public static String SECRET_KEY = "ui-AHrvBziDcxWKlllbG6o3HvtCePcureNZcidF1";
    public static String bucketname = "whyzaa-4";
    public static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    public static String getUpToken() {
        return auth.uploadToken(bucketname);
    }
}
