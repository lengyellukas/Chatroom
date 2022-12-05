package edu.udacity.java.nano.chat;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket Server
 *
 * @see ServerEndpoint WebSocket Client
 * @see Session   WebSocket Session
 */

@Component
@ServerEndpoint(value = "/chat/{username}", encoders = MessageEncoder.class)
public class WebSocketChatServer {

    /**
     * All chat sessions.
     */
    private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

    private static void sendMessageToAll(String msg) {
        for(Session s : onlineSessions.values()) {
            try {
                s.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Open connection, 1) add session, 2) add user.
     */
    @OnOpen
    public void onOpen(Session session) throws EncodeException {
        onlineSessions.put(session.getId(), session);
        int count = onlineSessions.size();

        Message msg = new Message();
        msg.setMessageType(Message.MessageType.ENTER);
        msg.setOnlineCount(count);

        MessageEncoder encoder = new MessageEncoder();
        sendMessageToAll(encoder.encode(msg));
    }

    /**
     * Send message, 1) get username and session, 2) send message to all.
     */
    @OnMessage
    public void onMessage(Session session, String jsonStr) {
        sendMessageToAll(jsonStr);
    }

    /**
     * Close connection, 1) remove session, 2) update user.
     */
    @OnClose
    public void onClose(Session session) throws EncodeException {
        onlineSessions.remove(session.getId());
        int count = onlineSessions.size();

        Message msg = new Message();
        msg.setMessageType(Message.MessageType.LEAVE);
        msg.setOnlineCount(count);

        MessageEncoder encoder = new MessageEncoder();
        sendMessageToAll(encoder.encode(msg));
    }

    /**
     * Print exception.
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

}
