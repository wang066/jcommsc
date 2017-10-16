package cn.jcomm.test.thridpack.packtest.netty.httpserver.base;

/**
 * Created by jowang on 2017/4/20 0020.
 * 可作为 RPC webapi 等结果基类
 */

public class Result<T> {

    private int code;
    private boolean success;
    private String msg;
    private T t;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Result(int code, boolean success, String msg, T t) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.t = t;
    }

    public static Result error(String msg) {
        return new Result(500, false, msg, null);
    }

    public static Result error(int code, String msg) {
        return new Result(code, false, msg, null);
    }

    public static <T> Result error(int code, String msg, T t) {
        return new Result(code, false, msg, t);
    }

    public static <T> Result success(T t) {
        return new Result(200, true, "", t);
    }
}
