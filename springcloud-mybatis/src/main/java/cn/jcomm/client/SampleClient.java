package cn.jcomm.client;

import cn.jcomm.model.SampleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "springcloud-service-user", fallback = SampleClient.SampleClientFallBackImpl.class)
public interface SampleClient {

//    @RequestMapping(value = "/api/task")
//    String task() ;
//
//    @RequestMapping("/h1")
//    String home(@RequestParam String email);

    @RequestMapping("/h2")
    SampleDto home();

    /**
     * 采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     */
    @Slf4j
    @Component
    class SampleClientFallBackImpl implements SampleClient {

        @Override
        public SampleDto home() {
            return new SampleDto();
        }
    }

}