package com.teamdev.students.chat.controller.dto;

public class UserResponse {
    private long userId;
    private String nickName;

    public UserResponse(){}

    public UserResponse(long userId, String nickName) {
        this.userId = userId;
        this.nickName = nickName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}