package com.teamdev.students.chat.model;


public class User {
    private long userId;
    private String nickName;
    private long numberOfShownMessages;
    private String userColor;

    public User(long userId, String nickName,
                long numberOfShownMessages, String userColor) {
        this.userId = userId;
        this.nickName = nickName;
        this.numberOfShownMessages = numberOfShownMessages;
        this.userColor = userColor;
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

    public String getUserColor() {
        return userColor;
    }

    public void setUserColor(String userColor) {
        this.userColor = userColor;
    }

    public void setNumberOfShownMessages(long numberOfShownMessages) {
        this.numberOfShownMessages = numberOfShownMessages;

    }
}
