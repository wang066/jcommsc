package cn.jcomm.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by 66wan on 2016/10/24 0024.
 * 状态码（http）
 */
@AllArgsConstructor
public enum ECode {

    Sys_Fail(100, "系统错误", "SysFail");

    @Getter
    private Integer index;
    @Getter
    private String cnName;
    @Getter
    private String enName;


}
