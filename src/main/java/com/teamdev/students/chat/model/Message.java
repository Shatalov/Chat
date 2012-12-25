package com.teamdev.students.chat.model;

import java.util.Date;

public class Message extends SimpleMessage {
    private long messageId;
    private Date postedAt;
    private long userId;

    public Message() {
    }

    public Message(String text, boolean toAll, long toUserId, long messageId, Date postedAt, long userId) {
        super(text, toAll, toUserId);
        this.messageId = messageId;
        this.postedAt = postedAt;
        this.userId = userId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
