package cn.jcomm.test.thridpack.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by jowang on 2016/11/15 0015.
 */
public class JsoupTest {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://www.oschina.net/")
                .data("Query", "Java")   // 请求参数
                .userAgent("I ’ m jsoup") // 设置 User-Agent
                .cookie("auth", "token") // 设置 cookie
                .timeout(3000)           // 设置连接超时时间
                .post();                 // 使用 POST 方法访问 URL
        System.out.println(doc.outerHtml());
    }
}
