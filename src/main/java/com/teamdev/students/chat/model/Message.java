package com.teamdev.students.chat.model;

import java.util.Date;

public class Message {
    private final long messageId;
    private final String text;
    private final Date postedAt;
    private final long userId;

    public Message(Long messageId, String text, Date postedAt, long userId) {
        this.messageId = messageId;
        this.text = text;
        this.postedAt = postedAt;
        this.userId = userId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public String getText() {
        return text;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", text='" + text + '\'' +
                ", postedAt=" + postedAt +
                ", userId=" + userId +
                '}';
    }
}
