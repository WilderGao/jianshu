package com.wilder.jianshu.service;

import com.google.gson.Gson;
import com.wilder.jianshu.model.Message;
import com.wilder.jianshu.model.TypeEnum;
import com.wilder.jianshu.model.WebSocketSessionMap;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Base64;

/**
 * @author:Wilder Gao
 * @time:2018/4/10
 * @Discription：
 */
@Service
public class QrService {
    private Gson gson = new Gson();

    public void handleIp(String sign , String ip) throws IOException {
        String idAddress = new String(Base64.getDecoder().decode(ip));
        WebSocketSession session = WebSocketSessionMap.getInstance().get(sign);
        Message message = new Message(TypeEnum.WEB_SIGN.getState(), "http://"+idAddress);
        TextMessage textMessage = new TextMessage(gson.toJson(message));
        session.sendMessage(textMessage);
    }
}
