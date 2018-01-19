package cn.jcomm.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.util.concurrent.TimeUnit;

/**
 * Created by jowang on 2018/1/19 0019.
 */
@Slf4j
public abstract class HttpUtils {

    private static final int TIME_OUT = 3 * 1000;

    private static final ConnectionKeepAliveStrategy CONNECTION_KEEP_ALIVE_STRATEGY;

    private static final PoolingHttpClientConnectionManager CLIENT_CONNECTION_MANAGER;

    private static final  RequestConfig REQUEST_CONFIG;
    static {
        //长连接策略
        CONNECTION_KEEP_ALIVE_STRATEGY = (response, context) -> 3000;

        //连接池
        CLIENT_CONNECTION_MANAGER = new PoolingHttpClientConnectionManager();
        CLIENT_CONNECTION_MANAGER.setMaxTotal(100);
        CLIENT_CONNECTION_MANAGER.closeExpiredConnections();
        CLIENT_CONNECTION_MANAGER.closeIdleConnections(30, TimeUnit.SECONDS);

        //请求配置
        REQUEST_CONFIG = RequestConfig.custom()
                .setConnectionRequestTimeout(TIME_OUT)
                .setConnectTimeout(TIME_OUT)
                .setSocketTimeout(TIME_OUT)
                .build();

    }

//    public String get(HttpGet httpGet) {
//        CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();
//        try {
//            // Start the client
//            httpclient.start();
//
//            // Execute request
//            final HttpGet request1 = new HttpGet("http://www.apache.org/");
//            Future<HttpResponse> future = httpclient.execute(request1, null);
//            // and wait until a response is received
//            HttpResponse response1 = future.get();
//            System.out.println(request1.getRequestLine() + "->" + response1.getStatusLine());
//
//            final HttpGet request2 = new HttpGet("http://www.apache.org/");
//            httpclient.execute(request2, new FutureCallback<HttpResponse>() {
//                @Override
//                public void completed(final HttpResponse response2) {
//
//                }
//                @Override
//                public void failed(final Exception ex) {
//
//                }
//
//                @Override
//                public void cancelled() {
//
//                }
//
//            });
//        } catch (Exception e) {
//
//        } finally {
//            httpclient.close();
//        }
//    }
}
