package cn.jcomm.controller;

import cn.jcomm.common.pojo.Result;
import cn.jcomm.model.DO.User;
import cn.jcomm.model.VO.QueryUser;
import cn.jcomm.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jowang on 2017/8/1 0001.
 */
@RestController
@Api("UserController")
@Slf4j
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * POST http://127.0.0.1:8080//api/user/ HTTP/1.1
     Host: 127.0.0.1:8080
     Connection: keep-alive
     Content-Length: 114
     Postman-Token: 8423eae3-6a06-5281-da3a-6a13d33fd92c
     Cache-Control: no-cache
     Origin: chrome-extension://aicmkgpgakddgnaphhhpliifpcfhicfo
     X-Postman-Interceptor-Id: c58802ba-a0fa-4be8-6e60-53635cf6956a
     User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.104 Safari/537.36
     Content-Type: application/x-www-form-urlencoded
     Accept: *//*
    Accept-Encoding: gzip, deflate, br
    Accept-Language: zh-CN,zh;q=0.8,en;q=0.6

            email=1&gender=2&birthday=2017-01-01 12:12:12&userName=4&userPwdHash=5&userPwdSalt=6&userType=7&roleIds=8&phone=9&address=10&status=
     * @param user
     * @return
     */
    @PostMapping(value = "/api/user/")
    public String add(@ModelAttribute User user) {
        userService.add(user);
        return Result.success(user).toJson();
    }

    @DeleteMapping(value = "/api/user/{id}")
    public String del(@PathVariable Long id) {
        User user=new User();
        userService.del(id);
        return Result.success(user).toJson();
    }

    @PutMapping(value = "/api/user/")
    public String update(@ModelAttribute User user) {
        userService.update(user);
        return Result.success(user).toJson();
    }

    @GetMapping(value = "/api/user/{id}")
    public String get(@PathVariable Long id) {
        User user= userService.get(id);
        return Result.success(user).toJson();
    }

    @GetMapping(value = "/api/users/")
    public String getList(@ModelAttribute QueryUser queryUser) {
        return Result.success(  userService.getList()).toJson();
    }
}
