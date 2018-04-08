package cn.jcomm.service;

import cn.jcomm.dao.CityRepository;
import cn.jcomm.model.DO.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jowang on 2017/7/13 0013.
 */
@Service
public class CityServiceImpl implements CityService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);
//    @Autowired
//    private CityMapper2 cityMapper2;

    @Autowired
    private CityRepository cityRepository;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public City add(City city) {
//        redisTemplate

        Integer insert = cityRepository.insert(city);
        city.setId(insert);
        return city;
    }

    @Override
    public City findByName(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        return cityRepository.selectOne(city);
    }
}
