package com.teamdev.students.chat.model;

public class SimpleMessage {

    private  String text;
    private  boolean toAll;
    private  long toUserId;

    public SimpleMessage(){}

    public SimpleMessage(String text, boolean toAll, long toUserId) {
        this.text = text;
        this.toAll = toAll;
        this.toUserId = toUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserNick) {
        this.toUserId = toUserNick;
    }

    public boolean isToAll() {
        return toAll;
    }

    public void setToAll(boolean toAll) {
        this.toAll = toAll;
    }
}
