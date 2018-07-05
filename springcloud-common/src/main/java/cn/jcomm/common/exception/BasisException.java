package cn.jcomm.common.exception;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常
 */
public class BasisException extends RuntimeException {

    /**
     * 异常信息
     */
    protected String msg;

    /**
     * 具体异常码
     */
    protected int code;

    protected boolean writeLog = true;

    protected Object info;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public boolean isWriteLog() {
        return writeLog;
    }

    public Object getInfo() {
        return info;
    }

    public BasisException setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public BasisException setCode(int code) {
        this.code = code;
        return this;
    }

    public BasisException setWriteLog(boolean writeLog) {
        this.writeLog = writeLog;
        return this;
    }

    public BasisException setInfo(Object info) {
        this.info = info;
        return this;
    }
}
