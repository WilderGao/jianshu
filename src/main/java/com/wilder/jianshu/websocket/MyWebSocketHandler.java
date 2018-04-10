package com.wilder.jianshu.websocket;

import com.google.gson.Gson;
import com.wilder.jianshu.model.Message;
import com.wilder.jianshu.model.TypeEnum;
import com.wilder.jianshu.model.UuidMap;
import com.wilder.jianshu.model.WebSocketSessionMap;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.UUID;

/**
 * @author:Wilder Gao
 * @time:2018/4/9
 * @Discription：
 */
@Component
@Slf4j
public class MyWebSocketHandler implements WebSocketHandler{
    private static final Logger logger = LoggerFactory.getLogger(MyWebSocketHandler.class);
    private static Gson gson = new Gson();
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.info("======== after connect established ==========");
        String uuid = UUID.randomUUID().toString();

        //将 uuid 和 session 对应
        WebSocketSessionMap.getInstance().put(uuid, webSocketSession);
        UuidMap.getInstance().put(webSocketSession, uuid);

        Message message = new Message(TypeEnum.SIGN.getState(), uuid);
        TextMessage send = new TextMessage(gson.toJson(message));
        webSocketSession.sendMessage(send);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        logger.info("======== handle message ========");
        logger.info(webSocketMessage.toString());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        logger.error("====== error occur ======");
        logger.error("reason is : " + throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        logger.info("======== after connection closed ========");
        logger.info("webSocketSession : " + webSocketSession);
        logger.info("reason : " + closeStatus.getReason());

        String uuid = UuidMap.getInstance().get(webSocketSession);
        UuidMap.getInstance().remove(webSocketSession);
        WebSocketSessionMap.getInstance().remove(uuid);

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
