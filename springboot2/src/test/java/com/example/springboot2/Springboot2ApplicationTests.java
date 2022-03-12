package com.example.springboot2;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
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


    @Test
    void test1() {
        System.out.println("--------------------");
    }

    @Test
    void test2() {
        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("#root.purchaseName");
        Order order = new Order();
        order.setPurchaseName("张三");
        System.err.println(expression.getValue(order));
    }

    @Getter
    @Setter
    public static class Order{
        private String purchaseName;
    }

    @Test
    public void test46k() {
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        List<CompletableFuture> futures= Lists.newArrayList();
        boolean done = CompletableFuture.runAsync(() -> {
            int i = 0;
            int j = 1 / i;
        }, threadPool).isDone();
        System.out.println(done);
        System.out.println("ok");
    }

    @Test
    void test47() {
        A a=new A(1);
        System.out.println(a.getI());
    }

    @Getter
    @AllArgsConstructor
    public static class A{
        private int i;
    }
}
