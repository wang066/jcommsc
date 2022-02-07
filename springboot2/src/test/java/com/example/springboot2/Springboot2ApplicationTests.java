package com.example.springboot2;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@SpringBootTest
class Springboot2ApplicationTests {

    public static void main(String[] args) {
        boolean flag = true;
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("hook execute...");
        }));

        while (flag) {
            // app is runing
        }

        System.out.println("main thread execute end...");
    }
}
