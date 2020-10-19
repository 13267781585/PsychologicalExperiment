package jianxin.psyExperiment.support.exceptionHandler.entity;

import org.apache.catalina.Server;

import java.io.Serializable;

public class ServerReturnObject implements Serializable {
    private int code;
    private String message;
    private Object data;

    private ServerReturnObject(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ServerReturnObject createErrorByMessage(String msg)
    {
        return new ServerReturnObject(-1,msg,null);
    }

    public static ServerReturnObject createSuccessByData(Object data)
    {
        return new ServerReturnObject(1,null,data);
    }

    public static ServerReturnObject createSuccessByMessageAndData(String msg,Object data)
    {
        return new ServerReturnObject(1,msg,data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
