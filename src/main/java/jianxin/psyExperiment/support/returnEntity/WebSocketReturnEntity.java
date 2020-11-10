package jianxin.psyExperiment.support.returnEntity;

import jianxin.psyExperiment.entity.ConsultMessage;
import jianxin.psyExperiment.entity.User;

import java.io.Serializable;
import java.util.List;

/*
    websocket 传输Bean
    code:
        a.客户端到服务端:1->发送消息
                      0->更新消息状态(是否已读)
        b.服务端到客户端:1->有新的消息
                      0->根据登录用户返回与其他人所有聊天记录

 */
public class WebSocketReturnEntity implements Serializable {
    private int code;

    private List<ConsultMessageCollection> consultMessages;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ConsultMessageCollection> getConsultMessages() {
        return consultMessages;
    }

    public void setConsultMessages(List<ConsultMessageCollection> consultMessages) {
        this.consultMessages = consultMessages;
    }

    private WebSocketReturnEntity(int code, List<ConsultMessageCollection> consultMessages) {
        this.code = code;
        this.consultMessages = consultMessages;
    }

    public static WebSocketReturnEntity CreateBySelectAllConsultMessage(List<ConsultMessageCollection> msg){
        return new WebSocketReturnEntity(0,msg);
    }

    public static WebSocketReturnEntity CreateBySendNewConsultMessage(List<ConsultMessageCollection> msg)
    {
        return new WebSocketReturnEntity(1,msg);
    }
}
