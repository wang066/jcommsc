package com.example.springboot2;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class Springboot2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2Application.class, args);
    }

    @Controller
    public class HomeController {
        @PostMapping("/")
        @ResponseBody
        public String index(@RequestBody FormMapVo formMapVo) {
            log.info(JSON.toJSONString(formMapVo));
            return "index";
        }

    }

    public static class FormMapVo {
        public FormMapVo() {
            map = new HashMap<>();
        }

        private Map<String, Object> map;

        private void setAge(int age) {
            map.put("age", age);
        }

        public int getAge() {
            return (int) map.get("age");
        }
    }


    @Component
    public static class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            System.out.println("[BeanFactoryPostProcessor]");
        }
    }

    @Component
    public class MyBeanPostProcessor implements BeanPostProcessor {

        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString());
            return bean;
        }

        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
            return bean;
        }
    }
    // public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    //
    //     @Override
    //     public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    //         System.out.println("[TestInstantiationAwareBeanPostProcessor] before initialization " + beanName);
    //         return bean;
    //     }
    //
    //     @Override
    //     public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    //         System.out.println("[TestInstantiationAwareBeanPostProcessor] after initialization " + beanName);
    //         return bean;
    //     }
    //
    //     @Override
    //     public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
    //         System.out.println("[TestInstantiationAwareBeanPostProcessor] before instantiation " + beanName);
    //         return null;
    //     }
    //
    //     @Override
    //     public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
    //         System.out.println("[TestInstantiationAwareBeanPostProcessor] after instantiation " + beanName);
    //         return true;
    //     }
    //
    //     @Override
    //     public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
    //         System.out.println("[TestInstantiationAwareBeanPostProcessor] postProcessPropertyValues " + beanName);
    //         return pvs;
    //     }
    // }

    // @Slf4j
    // @Service
    // @RocketMQMessageListener(topic = "test-topic-1", consumerGroup = "my-consumer_test-topic-1",consumeThreadMax = 16)
    // public class MyConsumer1 implements RocketMQListener<String> {
    //     public void onMessage(String message) {
    //         log.info("received message: {}", message);
    //     }
    // }

}
