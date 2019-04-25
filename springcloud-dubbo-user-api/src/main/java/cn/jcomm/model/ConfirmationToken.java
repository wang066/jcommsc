package cn.jcomm.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by jowang on 2017/8/1 0001.
 */
@Data
public class ConfirmationToken {
    private Long id;
//    private User user;
    private String value;
    private Boolean valid;
    private Date createTime;
    private Date modifiedTime;
    private Date expireTime;
}
