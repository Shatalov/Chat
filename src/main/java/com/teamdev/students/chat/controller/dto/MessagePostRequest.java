package com.teamdev.students.chat.controller.dto;

import com.teamdev.students.chat.model.SimpleMessage;

public class MessagePostRequest extends SimpleMessage {

      private  long userId;

    public MessagePostRequest() {
        super();
    }

    public MessagePostRequest(String text, boolean toAll, long toUserId, long userId) {
        super(text, toAll, toUserId);
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
