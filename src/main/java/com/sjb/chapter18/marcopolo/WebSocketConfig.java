package com.sjb.chapter18.marcopolo;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by simjunbo on 2018-08-07.
 */
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(marcoHandler(), "/marco").withSockJS();
    }

    @Bean
    public MarcoHandler marcoHandler() {
        return new MarcoHandler();
    }
}
