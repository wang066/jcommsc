package cn.jcomm.controller;

import cn.jcomm.client.SampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jowang on 2017/8/3 0003.
 */
@RestController
public class SampleController extends BaseController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SampleClient client;

    @RequestMapping("/h0")
    public String h0() {
        return "aaaaaaaaaaaaaa";

    }

    @RequestMapping("/h1")
    public String h1() {
        return restTemplate.getForObject("http://SPRINGCLOUD-SERVICE-USER//h1?email=1", String.class);

    }

    @RequestMapping("/h2")
    public String h2() {
       return client.home().toString();
    }

    @RequestMapping("/h3")
    public String h3() {
        return "33333";
    }
    public String ribbonFallback() {
        return "My Name's :ribbonFallback Email:1837307557@qq.com";
    }
}
