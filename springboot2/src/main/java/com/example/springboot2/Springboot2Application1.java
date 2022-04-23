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
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Condition;
// import org.springframework.context.annotation.ConditionContext;
// import org.springframework.context.annotation.Conditional;
// import org.springframework.core.type.AnnotatedTypeMetadata;
//
// /**
//  * 测下 condition
//  */
// @Slf4j
// @SpringBootApplication
// public class Springboot2Application1 {
//
//     public static void main(String[] args) {
//         ConfigurableApplicationContext context = SpringApplication.run(Springboot2Application1.class, args);
//         // BeanA bean = context.getBean(BeanA.class);
//     }
//
//
//     @Getter
//     @Setter
//     @NoArgsConstructor
//     @AllArgsConstructor
//     public static class BeanA {
//         private String msg;
//     }
//
//     @Conditional(MyCondition.class)
//     @Bean
//     public BeanA condition() {
//         System.err.println("自定义的condition的match方法返回值为true时，才会进入该方法创建bean");
//         return new BeanA();
//     }
//
//
//     public static class MyCondition implements Condition {
//         @Override
//         public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//             System.out.println("MyCondition:" + context.getEnvironment().getProperty("os.name"));
//             return context.getEnvironment().getProperty("os.name").contains("Mac");
//         }
//     }
//
// }
