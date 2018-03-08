package cn.jcomm.model;

import cn.jcomm.model.DO.User;
import lombok.Data;

import java.util.Date;

/**
 * Created by jowang on 2017/8/1 0001.
 */
@Data
public class UserEvent {
    private Long id;
    private User user;
    private EventType eventType;
    private Date occureAt;
}
