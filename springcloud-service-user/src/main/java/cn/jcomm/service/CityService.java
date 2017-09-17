package cn.jcomm.service;

import cn.jcomm.model.DO.City;

/**
 * Created by jowang on 2017/7/13 0013.
 */
public interface CityService {
    City add(City city);

    City findByName(String cityName);
}
