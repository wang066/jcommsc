// package com.example.springboot2;
//
// import com.alibaba.fastjson.JSON;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.BeansException;
// import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
// import org.springframework.beans.factory.config.BeanPostProcessor;
// import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContextAware;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.ResponseBody;
//
// import java.util.HashMap;
// import java.util.Map;
//
// @Slf4j
// @SpringBootApplication
// public class Springboot2Application {
//
//     public static void main(String[] args) {
//         SpringApplication.run(Springboot2Application.class, args);
//     }
//
//     @Controller
//     public class HomeController {
//         @PostMapping("/")
//         @ResponseBody
//         public String index(@RequestBody FormMapVo formMapVo) {
//             log.info(JSON.toJSONString(formMapVo));
//             return "index";
//         }
//
//     }
//
//     public static class FormMapVo {
//         public FormMapVo() {
//             map = new HashMap<>();
//         }
//
//         private Map<String, Object> map;
//
//         private void setAge(int age) {
//             map.put("age", age);
//         }
//
//         public int getAge() {
//             return (int) map.get("age");
//         }
//     }
//
//
//     @Component
//     public static class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
//         @Override
//         public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//             System.out.println("[BeanFactoryPostProcessor]");
//         }
//     }
//
//     //BeanPostProcessor 里调调这个看会怎么样
//     @Component
//     public static class BeanA {
//         public void print() {
//             System.out.println("BeanPostProcessor 里调调这个看会怎么样");
//         }
//     }
//
//     @Component
//     public static class MyBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
//
//
//         public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//             // context.getBean(BeanA.class).print();
//             System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString());
//             return bean;
//         }
//
//         public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//             System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString());
//             return bean;
//         }
//
//         public static ApplicationContext context;
//
//         @Override
//         public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//             context = applicationContext;
//         }
//     }
//
// }
