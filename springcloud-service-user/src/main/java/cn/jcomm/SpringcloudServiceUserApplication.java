package cn.jcomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableScheduling 自动有的
@EnableAsync
//@EnableDiscoveryClient
@ServletComponentScan
public class SpringcloudServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceUserApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
//        System.out.println("CommandLineRunner init");
//        String[] beanNames=ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
//        return null;
//    }
}
