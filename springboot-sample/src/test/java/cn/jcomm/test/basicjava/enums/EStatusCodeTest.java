package cn.jcomm.test.basicjava.enums;

/**
 * Created by 66wan on 2016/10/24 0024.
 * 状态码（http）
 */
public enum EStatusCodeTest {

    Sys_Fail(100, "系统错误", "Sys_Fail"),;


    private int index;
    private String cnname;
    private String enname;

    EStatusCodeTest(int index, String cnname, String enname) {
        this.index = index;
        this.cnname = cnname;
        this.enname = enname;
    }
}
