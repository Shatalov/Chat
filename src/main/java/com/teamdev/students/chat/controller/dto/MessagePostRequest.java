package com.teamdev.students.chat.controller.dto;


public class MessagePostRequest {
    private String text;
    private long userId;

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

    @Override
    public String toString() {
        return "MessagePostRequest{" +
                "text='" + text + '\'' +
                ", userId=" + userId +
                '}';
    }
}
