package cn.jcomm.service.impl;

import java.util.List;

import cn.jcomm.dao.UserRepository;
import cn.jcomm.model.DO.User;
import cn.jcomm.model.UserStatus;
import cn.jcomm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jowang on 2017/8/1 0001.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        userRepository.insert(user);
        return user;
    }

    @Override
    public Integer del(Long id) {
        User user = new User();
        user.setId(id);
        user.setStatus(UserStatus.Del);
        return userRepository.updateById(user);
    }

    @Override
    public Integer update(User user) {
        return userRepository.update(user, null);
    }

    @Override
    public User find(Long id) {
        return userRepository.selectById(id);
    }

    @Override
    public List<User> queryList() {
        return userRepository.selectList(null);
    }

}
