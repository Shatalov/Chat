package com.teamdev.students.chat.controller.dto;

import com.teamdev.students.chat.model.SimpleMessage;

public class MessageResponse {

    private  String textResp;
    private  boolean toAllResp;
    private String userNickPostedMessage;
    private  String toUserNick;

    public MessageResponse(){}

    public MessageResponse(String textResp, boolean toAllResp, String userNickPostedMessage, String toUserNick) {
        this.textResp = textResp;
        this.toAllResp = toAllResp;
        this.userNickPostedMessage = userNickPostedMessage;
        this.toUserNick = toUserNick;
    }

    public String getTextResp() {
        return textResp;
    }

    public void setTextResp(String textResp) {
        this.textResp = textResp;
    }

    public boolean isToAllResp() {
        return toAllResp;
    }

    public void setToAllResp(boolean toAllResp) {
        this.toAllResp = toAllResp;
    }

    public String getUserNickPostedMessage() {
        return userNickPostedMessage;
    }

    public void setUserNickPostedMessage(String userNickPostedMessage) {
        this.userNickPostedMessage = userNickPostedMessage;
    }

    public String getToUserNick() {
        return toUserNick;
    }

    public void setToUserNick(String toUserNick) {
        this.toUserNick = toUserNick;
    }
}
