package edu.udacity.java.nano.chat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * WebSocket message model
 */
public class Message {
    @JSONField(name = "Username")
    private String username;

    @JSONField(name = "Content")
    private String content;

    @JSONField(name = "MessageType")
    private MessageType messageType;

    @JSONField(name = "onlineCount")
    private int onlineCount;

    public enum MessageType {
        ENTER, CHAT, LEAVE
    }

    public Message() {}

    public Message(String username, String content, MessageType messageType, int onlineCount) {
        this.username = username;
        this.content = content;
        this.messageType = messageType;
        this.onlineCount = onlineCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }
}
