package com.example.springboot2;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class Springboot2ApplicationTests {

    @Data
    @AllArgsConstructor
    public static class User {
        private int age;
    }

    public static class UserObjectFactory implements ObjectFactory<User> {

        @Override
        public User getObject() throws BeansException {
            return new User(18);
        }
    }

    @Bean
    public ObjectFactory myObjectFactory() {
        return new UserObjectFactory();
    }
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        beanFactory.registerResolvableDependency(User.class, new UserObjectFactory());
        User bean = applicationContext.getBean(User.class);
        System.out.println(JSON.toJSONString(bean));
        // System.out.println(Json.convertObjectToJSON());
    }
}
