package jianxin.psyExperiment.controller;

import javax.websocket.Session;

public interface WebSocketController {
    void OnOpen(Session session,String userId) throws Exception;

    void OnClose();

    void OnMessage(String message);
}
