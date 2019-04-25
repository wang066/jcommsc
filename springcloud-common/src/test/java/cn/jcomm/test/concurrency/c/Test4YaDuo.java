package cn.jcomm.test.concurrency.c;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import junit.framework.TestCase;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang.math.RandomUtils;
import org.joda.time.DateTime;

/**
 * @author: jowang
 * @date: 2018-07-11 15:44
 * @description:
 */
public class Test4YaDuo extends TestCase {
    public static void main(String[] args) throws Exception {

        HashMap<String, Double> map = new HashMap<>();

        String cityName = URLEncoder.encode("杭州市", "UTF-8");
        //System.out.println(cityName);
        String beginDate = "2019-04-13";
        String endDate = "2019-04-14";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "activeId=0&activitySource=&appVer=1.15.0&beginDate=" + beginDate + "&channelId=20001&cityName=" + cityName + "&deviceId=35342258-F09B-4DB8-9097-B7344FB20042&endDate=" + endDate + "&inactiveId=&latitude=30.290462&longitude=120.069130&platType=2&token=b110e8a234b7453488cf2007b230d38b");
        Request request = new Request.Builder()
                .url("https://api2.yaduo.com/atourlife/chain/cityChainList")
                .post(body)
                .addHeader("cookie", "gr_user_id=01efd744-936d-40a6-b9e3-949e0119cb7b")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("host", "api2.yaduo.com")
                .addHeader("accept", "*/*")
                .addHeader("accept-language", "zh-Hans-CN;q=1")
                .addHeader("user-agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D39  kdtUnion_7cb80e476e3f865b68 AtourBrowser-")
                .addHeader("accept-encoding", "br,  deflate")
                .addHeader("connection", "keep-alive")
                .addHeader("cache-control", "no-cache")
                //.addHeader("postman-token", "2a5c80a9-5ebf-8305-5c63-805b2dd2313b")
                .build();
        while (true) {
            try {
                boolean low = false;
                System.out.println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
                Response response = client.newCall(request).execute();
                //System.out.println(new String(response.body().bytes(),"utf-8"));
                String sJson = new String(response.body().bytes(), "utf-8");
                JSONArray jaHotel = JSON.parseObject(sJson).getJSONArray("result");
                for (int i = 0; i < jaHotel.size(); i++) {
                    JSONObject joHotel = jaHotel.getJSONObject(i);
                    String name = joHotel.getString("name");
                    Double price = joHotel.getDouble("price");
                    if (!map.containsKey(name)) {
                        map.put(name, price);
                    }
                    if (price - map.get(name) > 1) {

                        low = true;
                        map.put(name, price);
                    }
                }
                if (low)
                    System.out.println("------------------------降价了-----------");
                System.out.println(JSON.toJSONString(map));

            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                TimeUnit.SECONDS.sleep(180 + RandomUtils.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
