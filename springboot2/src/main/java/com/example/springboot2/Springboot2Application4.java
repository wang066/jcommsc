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
// import org.springframework.context.annotation.ImportSelector;
// import org.springframework.core.type.AnnotationMetadata;
//
// /**
//  * 测下 ImportBeanDefinitionRegistrar
//  */
// @Slf4j
// @SpringBootApplication
// public class Springboot2Application4 {
//
//     public static void main(String[] args) {
//         ConfigurableApplicationContext context = SpringApplication.run(Springboot2Application4.class, args);
//         System.out.println(BeanA.class.getName());
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
//     @Import(MyImportSelector.class)
//     public static class Config {
//
//     }
//
//     public static class MyImportSelector implements ImportSelector {
//
//         @Override
//         public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//             return new String[]{BeanA.class.getName()};
//         }
//     }
//
// }
