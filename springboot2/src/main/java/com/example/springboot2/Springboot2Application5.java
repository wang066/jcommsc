// package com.example.springboot2;
//
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.FactoryBean;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.SpringBootConfiguration;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Slf4j
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @Configuration
// public class Springboot2Application5 {
//
//     public static void main(String[] args) {
//         ConfigurableApplicationContext applicationContext = SpringApplication.run(Springboot2Application5.class, args);
//         System.out.println("容器启动完成");
//         UserService userService = applicationContext.getBean(UserService.class);
//         System.out.println(userService);
//         Object customerFactoryBean = applicationContext.getBean("customerFactoryBean");
//         System.out.println(customerFactoryBean);
//     }
//
//     public static class UserService {
//         public UserService() {
//             System.out.println("UserService");
//         }
//     }
//
//     // @Component(value = "customerFactoryBean")
//     public class CustomerFactoryBean implements FactoryBean {
//         public int type;
//
//         @Override
//         public UserService getObject() throws Exception {
//             return new UserService();
//         }
//
//         @Override
//         public Class<?> getObjectType() {
//             return UserService.class;
//         }
//     }
//
//     // @Bean
//     // @ConditionalOnBean()
//     // public CustomerFactoryBean createCustomerFactoryBean() {
//     //     CustomerFactoryBean factoryBean = new CustomerFactoryBean();
//     //     factoryBean.type = 3;
//     //     return factoryBean;
//     // }
//
// }
