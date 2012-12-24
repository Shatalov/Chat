package com.teamdev.students.chat.model;


public class User {
    private long userId;
    private String nickName;
    private long numberOfShownMessages;
    private Color  userColor;

    public User(long userId, String nickName) {
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

    public long getNumberOfShownMessages() {
        return numberOfShownMessages;
    }

    public Color getUserColor() {
        return userColor;
    }

    public void setUserColor(Color userColor) {
        this.userColor = userColor;
    }

    public void setNumberOfShownMessages(long numberOfShownMessages) {
        this.numberOfShownMessages = numberOfShownMessages;

    }
}
