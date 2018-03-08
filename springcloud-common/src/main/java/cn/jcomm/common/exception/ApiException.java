package cn.jcomm.common.exception;

/**
 * Created by 066 on 2017/7/13 0013.
 */
public class ApiException extends BasisException {

    private boolean writeLog = true;
    private Object info;

    public boolean isWriteLog() {
        return writeLog;
    }

    public void setWriteLog(boolean writeLog) {
        this.writeLog = writeLog;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
