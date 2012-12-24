package com.teamdev.students.chat.model;

import java.util.Date;

public class Message {
    private final long messageId;
    private final String text;
    private final Date postedAt;
    private final long userId;
    private final boolean toAll;
    private final long toUserId;

    public Message(Long messageId, String text, Date postedAt, long userId, boolean toAll, long toUserId) {
        this.messageId = messageId;
        this.text = text;
        this.postedAt = postedAt;
        this.userId = userId;
        this.toAll = toAll;
        this.toUserId = toUserId;
    }

    public Message(Long messageId, String text, Date postedAt, long userId) {
        this.messageId = messageId;
        this.text = text;
        this.postedAt = postedAt;
        this.userId = userId;
        this.toAll = false;
        this.toUserId = 0;
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
