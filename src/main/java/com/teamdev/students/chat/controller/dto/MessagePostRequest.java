package com.teamdev.students.chat.controller.dto;

import com.teamdev.students.chat.model.SimpleMessage;

public class MessagePostRequest extends SimpleMessage {

    private long userIdM;

    public MessagePostRequest() {
        super();
    }

    public MessagePostRequest(String text, boolean toAll, long toUserId, long userId) {
        super(text, toAll, toUserId);
        this.userIdM = userId;
    }

    public long getUserIdM() {
        return userIdM;
    }

    public void setUserIdM(long userId) {
        this.userIdM = userId;
    }
}
