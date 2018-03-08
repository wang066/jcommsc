package cn.jcomm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-context-task.xml"})
public class SpringcloudServiceJobApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServiceJobApiApplication.class, args);
	}
}
