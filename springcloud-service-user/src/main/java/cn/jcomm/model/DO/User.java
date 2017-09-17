package cn.jcomm.model.DO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class User implements Serializable {

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ID_WORKER)
    private Long id;

    private String email;

    private Integer gender;

    private Date birthday;

    private String userName;

    private String userPwdHash;

    private String userPwdSalt;

    private Integer userType;

    private String roleIds;

    private String phone;

    private String address;

    private Integer status;

    private String createUser;

    private Date createTime;

    private String modifiedUser;

    private Date modifiedTime;

}