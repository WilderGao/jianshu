package com.wilder.jianshu.model;

import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:Wilder Gao
 * @time:2018/4/10
 * @Discription：
 */
public class UuidMap {
    private ConcurrentHashMap<WebSocketSession, String> map = new ConcurrentHashMap<>();

    /**
     * 静态内部存储单例对象
     */
    private static class SignalUuidMap {
        private static UuidMap map = new UuidMap();
    }

    /**
     * 获取单例对象
     */
    public static UuidMap getInstance(){
        return SignalUuidMap.map;
    }

    public String get(WebSocketSession webSocketSession){
        return map.get(webSocketSession);
    }

    public void put(WebSocketSession socketSession, String uuid){
        map.put(socketSession, uuid);
    }

    public void remove(WebSocketSession webSocketSession){
        map.remove(webSocketSession);
    }
}
