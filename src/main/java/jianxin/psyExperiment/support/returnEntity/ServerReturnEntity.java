package jianxin.psyExperiment.support.returnEntity;

import java.io.Serializable;

public class ServerReturnEntity implements Serializable {
    private int code;
    private String message;
    private Object data;

    private ServerReturnEntity(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ServerReturnEntity createErrorByMessage(String msg)
    {
        return new ServerReturnEntity(-1,msg,null);
    }

    public static ServerReturnEntity createSuccessByData(Object data)
    {
        return new ServerReturnEntity(1,null,data);
    }

    public static ServerReturnEntity createSuccessByMessage(String msg)
    {
        return new ServerReturnEntity(1,msg,null);
    }

    public static ServerReturnEntity createSuccessByMessageAndData(String msg, Object data)
    {
        return new ServerReturnEntity(1,msg,data);
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
