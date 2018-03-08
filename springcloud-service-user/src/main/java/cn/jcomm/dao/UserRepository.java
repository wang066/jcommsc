package cn.jcomm.dao;

import cn.jcomm.common.SuperMapper;
import cn.jcomm.model.DO.User;
import org.springframework.stereotype.Repository;

/**
 * Created by jowang on 2017/8/1 0001.
 */
@Repository
public interface UserRepository extends SuperMapper<User> {
}
