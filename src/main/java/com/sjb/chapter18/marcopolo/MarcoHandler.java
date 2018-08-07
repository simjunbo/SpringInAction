package com.sjb.chapter18.marcopolo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Created by simjunbo on 2018-08-07.
 */
public class MarcoHandler extends TextWebSocketHandler {
    private static final Logger logger =
            LoggerFactory.getLogger(MarcoHandler.class);

    @Override
    protected void handleTextMessage(
            WebSocketSession session, TextMessage message) throws Exception {
        logger.info("Received message: " + message.getPayload());
        Thread.sleep(2000);

        session.sendMessage(new TextMessage("Polo!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("Conneciton established");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("Connection closed. Status: " + status);
    }
}
