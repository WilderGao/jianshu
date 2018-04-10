package com.wilder.jianshu.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author:Wilder Gao
 * @time:2018/4/9
 * @Discription：
 */
@Component
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{

    @Autowired
    private MyWebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws").addInterceptors(new HandShake()).setAllowedOrigins("*");
        registry.addHandler(webSocketHandler, "/ws/websocket").addInterceptors(new HandShake()).setAllowedOrigins("*").withSockJS();
    }
}
