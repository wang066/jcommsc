// package com.example.springboot2;
//
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Import;
//
// /**
//  * 测下 Import
//  */
// @Slf4j
// @SpringBootApplication
// public class Springboot2Application2 {
//
//     public static void main(String[] args) {
//         ConfigurableApplicationContext context = SpringApplication.run(Springboot2Application2.class, args);
//         BeanA bean = context.getBean(BeanA.class);
//         System.out.println(bean.getMsg());
//     }
//
//
//     @Getter
//     @Setter
//     @NoArgsConstructor
//     @AllArgsConstructor
//     public static class BeanA {
//         private String msg = "123";
//     }
//
//     @Configuration
//     @Import(BeanA.class)
//     public static class Config {
//
//     }
//
// }
