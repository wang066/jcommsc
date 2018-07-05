package cn.jcomm.service;

import cn.jcomm.model.DO.User;

import java.util.List;

/**
 * Created by jowang on 2017/8/1 0001.
 */
public interface UserService {

    User add(User user);

    Integer del(Long id);

    Integer update(User user);

    User find(Long id);

    List<User> queryList();
}
