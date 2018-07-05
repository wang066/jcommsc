package cn.jcomm.test.okhttp;

import junit.framework.TestCase;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author: jowang
 * @date: 2018-07-05 17:38
 * @description:
 */
public class UnitTest1 extends TestCase{
    OkHttpClient client = new OkHttpClient();

    public void test1() throws Exception{
        Request request = new Request.Builder().url("https://baidu.com").headers(Headers.of("1","1")).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            System.out.println(response.body().string());
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
