package cn.jcomm.test.hystrix;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public abstract class HttpUtils {

    /**
     * HttpUtils
     */
    public static final HttpUtils TEMP = new HttpUtils() {
        @Override protected void init() {
            cm = new PoolingHttpClientConnectionManager();
            cm.setMaxTotal(20);// 整个连接池最大连接数
            cm.setDefaultMaxPerRoute(5);// 每路由最大连接数，默认值是2
            cm.setValidateAfterInactivity(10000);
        }

        @Override protected CloseableHttpClient getHttpClient() {
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(3000).build();
            return HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(requestConfig).build();
        }
    };

    private static final String EMPTY_STR = "";
    private static final String UTF_8 = "UTF-8";
    protected PoolingHttpClientConnectionManager cm;

    protected HttpUtils() {
        init();
    }

    /**
     * init PoolingHttpClientConnectionManager
     */
    protected abstract void init();

    protected abstract CloseableHttpClient getHttpClient();

    /**
     * 设置请求头
     *
     * @param http    发送的HTTP请求
     * @param headers 请求头
     * @return 发送的HTTP请求
     */
    private HttpRequestBase setHeaders(HttpRequestBase http, Map<String, Object> headers) {
        if (null != headers) {
            for (Map.Entry<String, Object> param : headers.entrySet()) {
                http.addHeader(param.getKey(), String.valueOf(param.getValue()));
            }
        }
        return http;
    }

    /**
     * 将参数转为特定格式
     *
     * @param params 参数
     * @return
     */
    private ArrayList<NameValuePair> covertParams2NVPS(Map<String, Object> params) {
        ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
        if (null != params) {
            for (Map.Entry<String, Object> param : params.entrySet()) {
                pairs.add(new BasicNameValuePair(param.getKey(), String.valueOf(param.getValue())));
            }
        }
        return pairs;
    }

    /**
     * 处理Http请求
     *
     * @param request
     * @return
     */
    private String getResult(HttpRequestBase request) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                response.close();
                return result;
            }
        } finally {
            response.close();
        }

        return EMPTY_STR;
    }

    /**
     * some http request just return the headers. such as head
     *
     * @param request
     * @return
     */
    private Header[] getHeaders(HttpRequestBase request) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            return response.getAllHeaders();
        } finally {
            response.close();
        }
    }

    /**
     * 发送GET请求
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws URISyntaxException
     */
    public String get(String url) throws URISyntaxException, IOException {
        return get(url, null);
    }

    /**
     * 发送GET请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws URISyntaxException
     */
    public String get(String url, Map<String, Object> params) throws URISyntaxException, IOException {
        return get(url, null, params);
    }

    /**
     * 发送GET请求
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws URISyntaxException
     */
    public String get(String url, Map<String, Object> headers, Map<String, Object> params) throws URISyntaxException, IOException {
        URIBuilder ub = new URIBuilder(url);
        ub.setPath(url);
        //设置参数
        ub.setParameters(covertParams2NVPS(params));
        HttpGet httpGet = new HttpGet(ub.build());
        //设置请求头
        httpGet = (HttpGet) setHeaders(httpGet, headers);

        return getResult(httpGet);
    }

    /**
     * 发送POST请求
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String post(String url) throws IOException {
        return post(url, null);
    }

    /**
     * 发送POST请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String post(String url, Map<String, Object> params) throws IOException {
        return post(url, null, params);
    }

    /**
     * 发送POST请求
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String post(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        //设置参数
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPost.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        //设置请求头
        httpPost = (HttpPost) setHeaders(httpPost, headers);
        return getResult(httpPost);
    }

    /**
     * 发送PUT请求
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String put(String url) throws IOException {
        return put(url, null);
    }

    /**
     * 发送PUT请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String put(String url, Map<String, Object> params) throws IOException {
        return put(url, null, params);
    }

    /**
     * 发送PUT请求
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String put(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException {
        HttpPut httpPut = new HttpPut(url);
        //设置请求参数
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPut.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        //设置请求头
        httpPut = (HttpPut) setHeaders(httpPut, headers);

        return getResult(httpPut);
    }

    /**
     * 发送PATCH请求
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String patch(String url) throws IOException {
        return patch(url, null);
    }

    /**
     * 发送PATCH请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String patch(String url, Map<String, Object> params) throws IOException {
        return patch(url, null, params);
    }

    /**
     * 发送PATCH请求
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String patch(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException {
        HttpPatch httpPatch = new HttpPatch(url);
        //设置请求参数
        ArrayList<NameValuePair> pairs = covertParams2NVPS(params);
        httpPatch.setEntity(new UrlEncodedFormEntity(pairs, UTF_8));
        //设置请求头
        httpPatch = (HttpPatch) setHeaders(httpPatch, headers);

        return getResult(httpPatch);
    }

    /**
     * 发送DELETE请求
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String delete(String url) throws IOException, URISyntaxException {
        return delete(url, null);
    }

    /**
     * 发送DELETE请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String delete(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        return delete(url, null, params);
    }

    /**
     * 发送DELETE请求
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String delete(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置请求参数
        ub.addParameters(covertParams2NVPS(params));
        HttpDelete httpDelete = new HttpDelete(ub.build());
        //设置请求头
        httpDelete = (HttpDelete) setHeaders(httpDelete, headers);

        return getResult(httpDelete);
    }

    /**
     * 发送TRACE请求
     * 回显服务器收到的请求，主要用于测试或诊断。
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String trace(String url) throws IOException, URISyntaxException {
        return trace(url, null);
    }

    /**
     * 发送TRACE请求
     * 回显服务器收到的请求，主要用于测试或诊断
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String trace(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        return trace(url, null, params);
    }

    /**
     * 发送TRACE请求
     * 回显服务器收到的请求，主要用于测试或诊断
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     */
    public String trace(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置请求参数
        ub.setParameters(covertParams2NVPS(params));
        HttpTrace httpTrace = new HttpTrace(ub.build());
        //设置请求头
        httpTrace = (HttpTrace) setHeaders(httpTrace, headers);

        return getResult(httpTrace);
    }

    /**
     * 发送HEAD请求
     * 类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public Header[] head(String url) throws IOException, URISyntaxException {
        return head(url, null);
    }

    /**
     * 发送HEAD请求
     * 类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public Header[] head(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        return head(url, null, params);
    }

    /**
     * 发送HEAD请求
     * 类似于get请求，只不过返回的响应中没有具体的内容，用于获取报头
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public Header[] head(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置请求参数
        ub.setParameters(covertParams2NVPS(params));
        HttpHead httpHead = new HttpHead(ub.build());
        //设置请求头
        httpHead = (HttpHead) setHeaders(httpHead, headers);

        return getHeaders(httpHead);
    }

    /**
     * 发送OPTIONS请求
     * 允许客户端查看服务器的性能
     *
     * @param url 请求路径
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String options(String url) throws IOException, URISyntaxException {
        return options(url, null);
    }

    /**
     * 发送OPTIONS请求
     * 允许客户端查看服务器的性能
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String options(String url, Map<String, Object> params) throws IOException, URISyntaxException {
        return options(url, null, params);
    }

    /**
     * 发送OPTIONS请求
     * 允许客户端查看服务器的性能
     *
     * @param url     请求路径
     * @param headers 请求头
     * @param params  请求参数
     * @return 请求结果
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    public String options(String url, Map<String, Object> headers, Map<String, Object> params) throws IOException, URISyntaxException {
        URIBuilder ub = new URIBuilder();
        ub.setPath(url);
        //设置参数
        ub.setParameters(covertParams2NVPS(params));
        HttpOptions httpOptions = new HttpOptions(ub.build());
        //设置请求头
        httpOptions = (HttpOptions) setHeaders(httpOptions, headers);

        return getResult(httpOptions);
    }

    public static void main(String[] args) {
        try {
            String s = HttpUtils.TEMP.get("http://www.baidu.com");
            System.out.println(s);
        } catch (Exception e){
            e.printStackTrace();
        }


//        try {
//            String url = "http://www.baidu.com";
//            /**
//             *  请求参数配置
//             *  connectionRequestTimeout:
//             *                          从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
//             *                          会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
//             *  connectTimeout:
//             *                  连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
//             *  socketTimeout:
//             *                  服务器返回数据(response)的时间，超过该时间抛出read timeout
//             */
//            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
//                    .setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build()).build();
//
//            HttpPost post = new HttpPost(url);
////          HttpGet get = new HttpGet(url);
//
//            CloseableHttpResponse response = client.execute(post);
////          CloseableHttpResponse response = client.execute(get);
//
//            // 服务器返回码
//            int status_code = response.getStatusLine().getStatusCode();
//            System.out.println("status_code = " + status_code);
//
//            // 服务器返回内容
//            String respStr = null;
//            HttpEntity entity = response.getEntity();
//            if(entity != null) {
//                respStr = EntityUtils.toString(entity, "UTF-8");
//            }
//            System.out.println("respStr = " + respStr);
//            // 释放资源
//            EntityUtils.consume(entity);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}