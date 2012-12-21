package com.teamdev.students.chat.controller.dto;

public class MessageResponse {

    private String text;
    private long userId;

    public MessageResponse(String text, long userId) {
        this.text = text;
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
