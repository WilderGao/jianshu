package com.wilder.jianshu.model;


import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:Wilder Gao
 * @time:2018/4/10
 * @Discription：
 */
public class WebSocketSessionMap {
    private ConcurrentHashMap<String, WebSocketSession> map = new ConcurrentHashMap<>();

    /**
     * 静态内部存储单例对象
     */
    private static class SignalWebSocketSessionMap {
        private static WebSocketSessionMap map = new WebSocketSessionMap();
    }

    /**
     * 获取单例对象
     */
    public static WebSocketSessionMap getInstance(){
        return SignalWebSocketSessionMap.map;
    }

    public WebSocketSession get(String uuid){
        return map.get(uuid);
    }

    public void put(String uuid, WebSocketSession socketSession){
        map.put(uuid, socketSession);
    }
}
