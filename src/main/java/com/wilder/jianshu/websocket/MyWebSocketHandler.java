package com.wilder.jianshu.websocket;

import com.google.gson.Gson;
import com.wilder.jianshu.model.Message;
import com.wilder.jianshu.model.TypeEnum;
import com.wilder.jianshu.model.WebSocketSessionMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.Base64;
import java.util.UUID;

/**
 * @author:Wilder Gao
 * @time:2018/4/9
 * @Discription：
 */
@Component
@Slf4j
public class MyWebSocketHandler implements WebSocketHandler{

    private static Gson gson = new Gson();
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println("connection established");
        String uuid = UUID.randomUUID().toString();
        //将 uuid 和 session 对应
        WebSocketSessionMap.getInstance().put(uuid, webSocketSession);
        Message message = new Message(TypeEnum.SIGN.getState(), uuid);
        TextMessage send = new TextMessage(gson.toJson(message));
        webSocketSession.sendMessage(send);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
