package cn.jcomm.common.pojo;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import static cn.jcomm.common.constant.SystemConst.FAIL;
import static cn.jcomm.common.constant.SystemConst.SUCCESS;

/**
 * Created by jowang on 2017/4/20 0020.
 * 可作为 RPC webapi 等结果基类
 */
@Data
public class Result<T> {

    private int code;
    private boolean success;
    private String msg;
    private T data;


    public Result(int code, boolean success, String msg, T data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static Result error(String msg) {
        return new Result(FAIL, false, msg, null);
    }

    public static Result error(int code, String msg) {
        return new Result(code, false, msg, null);
    }

    public static <T> Result error(int code, String msg, T t) {
        return new Result(code, false, msg, t);
    }

    public static <T> Result success(T t) {
        return new Result(SUCCESS, true, "", t);
    }

    public String toJson(){
        return JSON.toJSONString(this);
    }
}
