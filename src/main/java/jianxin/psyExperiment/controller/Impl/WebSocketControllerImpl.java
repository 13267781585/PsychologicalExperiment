package jianxin.psyExperiment.controller.Impl;

import com.alibaba.fastjson.JSON;
import jianxin.psyExperiment.controller.WebSocketController;
import jianxin.psyExperiment.entity.ConsultMessage;
import jianxin.psyExperiment.service.ConsultMessageService;
import jianxin.psyExperiment.support.returnEntity.WebSocketReturnEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.function.ServerResponse;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @ServerEndpoint 这个注解有什么作用？
 *
 * 这个注解用于标识作用在类上，它的主要功能是把当前类标识成一个WebSocket的服务端
 * 注解的值用户客户端连接访问的URL地址
 *
 */

@Controller
@ServerEndpoint(value = "/websocket/{user_id}")
public class WebSocketControllerImpl  implements WebSocketController{

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketControllerImpl.class);

    //  这里使用静态，让 service 属于类
    private static ConsultMessageService consultMessageService;

    // 注入的时候，给类的 service 注入
    @Autowired
    public void setConsultMessageService(ConsultMessageService consultMessageService) {
        this.consultMessageService = consultMessageService;
    }

    /**
     *  与某个客户端的连接对话，需要通过它来给客户端发送消息
     */
    private Session session;

    /**
     * 标识当前连接客户端的用户名
     */
    private String userId;

    /**
     *  用于存所有的连接服务的客户端，这个对象存储是安全的
     */
    private static ConcurrentHashMap<String, WebSocketController> webSocketSet = new ConcurrentHashMap<>();


    /*
    客户端和服务端建立连接
    返回之前的聊天记录
     */
    @OnOpen
    public void OnOpen(Session session, @PathParam("user_id") String userId) throws Exception {
        this.session = session;
        this.userId = userId;

        //把当前用户会话缓存
        if(!webSocketSet.containsKey(userId))
            webSocketSet.put(this.userId,this);
        LOGGER.info("[WebSocket] 连接成功，当前连接人数:" + webSocketSet.size());

        //返回用户聊天记录
        WebSocketReturnEntity webSocketReturnEntity =  consultMessageService.selectAllConsultMessageByUserId(Integer.parseInt(userId));
        session.getBasicRemote().sendText(JSON.toJSONString(webSocketReturnEntity));
    }

    @OnClose
    public void OnClose(){
    }

    /*

     */
    @OnMessage
    public void OnMessage(String message){
    }
}
