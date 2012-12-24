package com.teamdev.students.chat;


import com.teamdev.students.chat.model.Message;
import com.teamdev.students.chat.model.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ChatContext {
    private long numberOfMessages;
    private long numberOfUsers;
    private List<User> users = new LinkedList<User>();
    private List<Message> messages = new LinkedList<Message>();
    private List<String> colorsAvailable = new LinkedList<String>();
//    private Map<Long,User >= new LinkedHashMap<Long,User>();

    public  ChatContext(){
        colorsAvailable.add("Black");
        colorsAvailable.add("Reg");
        colorsAvailable.add("Green");
        colorsAvailable.add("Blue");
        colorsAvailable.add("Brown");

        users.add(new User(1, "Yar",1, colorsAvailable.get(0)));
        users.add(new User(2, "Gello",1, colorsAvailable.get(0)));
        users.add(new User(3, "Pele", 1, colorsAvailable.get(0)));
    }

    public void addUser(User user) {
        users.add(user);
        numberOfUsers++;
    }

    public void addMessage(Message mess) {
        messages.add(mess);
        numberOfMessages++;
    }

    public User getUserById(long id) {
        for (User us : users) {
            if (us.getUserId() == id)
                return us;
        }
        return null;
    }

    public Message getMessageById(long id) {
        for (Message mess : messages) {
            if (mess.getMessageId() == id)
                return mess;
        }
        return null;
    }

    public List<String> getColorsAvailable() {
        return colorsAvailable;
    }

    public void setColorsAvailable(List<String> colorsAvailable) {
        this.colorsAvailable = colorsAvailable;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getNumberOfMessages() {
        return numberOfMessages;
    }

    public long getNumberOfUsers() {
        return numberOfUsers;
    }
}
