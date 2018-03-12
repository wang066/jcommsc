package cn.jcomm.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by 66wan on 2016/10/24 0024.想做异常
 * 状态码（http）
 */
@AllArgsConstructor
public enum ECode {

    SysFail(100, "系统错误", "发生系统错误了");

    @Getter
    private Integer index;
    @Getter
    private String name;
    @Getter
    private String desc;


}
