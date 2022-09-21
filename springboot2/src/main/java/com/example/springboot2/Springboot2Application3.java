// package com.example.springboot2;
//
// import lombok.*;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.FactoryBean;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.support.BeanDefinitionRegistry;
// import org.springframework.beans.factory.support.BeanNameGenerator;
// import org.springframework.beans.factory.support.RootBeanDefinition;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.properties.ConfigurationProperties;
// import org.springframework.boot.context.properties.EnableConfigurationProperties;
// import org.springframework.context.ConfigurableApplicationContext;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Import;
// import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
// import org.springframework.core.type.AnnotationMetadata;
// import org.springframework.stereotype.Component;
//
// /**
//  * 测下 ImportBeanDefinitionRegistrar
//  */
// @Slf4j
// @SpringBootApplication
// @EnableConfigurationProperties(Springboot2Application3.ConfigProperties.class)
// public class Springboot2Application3 {
//
//     public static void main(String[] args) {
//         ConfigurableApplicationContext context = SpringApplication.run(Springboot2Application3.class, args);
//         BeanA bean = context.getBean(BeanA.class);
//         System.out.println(bean.getMsg());
//
//         ConfigProperties configProperties = context.getBean(ConfigProperties.class);
//         System.out.println(configProperties.getHostName());
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
//     @Data
//     @ConfigurationProperties(prefix = "mail")
//     public class ConfigProperties {
//
//         private String hostName;
//         private int port;
//         private String from;
//
//     }
//
//     @Configuration
//     @Import(MyImportRegistrar.class)
//     public static class Config {
//
//     }
//
//     public static class MyImportRegistrar implements ImportBeanDefinitionRegistrar {
//         @Override
//         public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
//             registry.registerBeanDefinition("beanA", new RootBeanDefinition(BeanA.class));
//         }
//     }
//
// }
