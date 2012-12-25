package com.teamdev.students.chat.model;


import com.teamdev.students.chat.controller.dto.UserResponse;

public class User extends UserResponse {

    private long numberOfShownMessages;
    private Color userColor;

    public User(long userId, String nickName, long numberOfShownMessages, Color userColor) {
        super(userId, nickName);
        this.numberOfShownMessages = numberOfShownMessages;
        this.userColor = userColor;
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

    public void addNumberOfShownMessages() {
        numberOfShownMessages++;

    }
}
