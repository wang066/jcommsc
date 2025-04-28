package cn.jcomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jowang on 2017/4/18 0018.
 */
@Controller
public class HomeController    {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home2")
    public String home2() {
        return "home2";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
