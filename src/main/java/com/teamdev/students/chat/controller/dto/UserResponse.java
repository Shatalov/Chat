package com.teamdev.students.chat.controller.dto;

public class UserResponse {
    private long idUser;
    private String nickName;

    public UserResponse() {
    }

    public UserResponse(long userId, String nickName) {
        this.idUser = userId;
        this.nickName = nickName;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long userId) {
        this.idUser = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
