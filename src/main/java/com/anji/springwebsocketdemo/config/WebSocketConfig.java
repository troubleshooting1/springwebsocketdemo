package com.anji.springwebsocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Description:
 * author: chenqiang
 * date: 2018/6/8 9:34
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 注册stomp的端点
     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
     * withSockJS：使用SockJS协议
     * @param registry
     */
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint("/api/v1/socket")
                .setAllowedOrigins("*")         //允许跨域访问
                .withSockJS();
    }

    /**
     * 配置消息代理
     * 启动Broker，消息的发送地址符合配置的前缀来的消息才发送到这个broker
     * @param registry
     */
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/api/v1/socket/send");     //推送消息前缀
        registry.setApplicationDestinationPrefixes("/api/v1/socket/req");           //应用请求前缀
        registry.setUserDestinationPrefix("/user");                                 //推送用户前缀
    }
}
