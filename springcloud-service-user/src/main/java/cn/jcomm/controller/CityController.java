package cn.jcomm.controller;

import cn.jcomm.model.DO.City;
import cn.jcomm.service.CityService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 066 on 2017/7/9 0009.
 */
@RestController
@Api("Hello Controller")
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/api/city/add")
    public City add() {
        City city = new City();
        city.setCityName("杭州");
        city.setDescription("西湖");
        city.setProvinceId(310000L);
        return cityService.add(city);
    }

    @ApiOperation("mybatis test")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "cityName", dataType = "String", required = true, value = "城市名称", defaultValue = "温州"),
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
    })
    @GetMapping(value = "/api/city/{cityName}")
    public String get(@PathVariable  String cityName) {

        stringRedisTemplate.opsForValue().set("1","1");
        System.out.println(stringRedisTemplate.opsForValue().get("1"));

        log.info("查询" + cityName);

        return JSON.toJSONString(cityService.findByName(cityName));
    }


}
