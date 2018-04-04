package cn.jcomm.controller;

import cn.jcomm.client.SampleClient;
import cn.jcomm.model.SampleDto;
import cn.jcomm.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jowang on 2017/8/3 0003.
 */
@RestController
@Slf4j
public class SampleController implements SampleClient {
//    @Autowired
//    private BlogProperties blogProperties;

    @Autowired
    private AsyncService asyncService;
    @Value("${spring.application.name}")
    private String applicationName;

//    @ApiOperation("blogProperties test")
//    @RequestMapping(value = "/")
//    public String index() {
//        return JSON.toJSONString(blogProperties);
//    }

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
//    public String add(@RequestParam Integer a, @RequestParam Integer b) {
//        ServiceInstance instance = discoveryClient.getInstancesById("");
//        Integer r = a + b;
//        log.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
//        return "From Service-A, Result is " + r;
//    }

    @GetMapping(value = "/api/task")
    public String task()  {
        try {
            asyncService.task1();
            asyncService.task2();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "task";
    }

    @RequestMapping("/h1")
    public String home(@RequestParam @NotBlank String email) {
        log.info("[email] - [{}]", email);
        return "My Name's :" + "applicationName" + " Email:" + email;
    }

    @Override
    @RequestMapping("/h2")
    public SampleDto home() {
        Map map=new HashMap();
        map.put("1","map");
        return new SampleDto(100L,"1", map);
    }
}
