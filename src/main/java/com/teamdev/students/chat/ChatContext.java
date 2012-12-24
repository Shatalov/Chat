package com.teamdev.students.chat;


import com.teamdev.students.chat.model.Message;
import com.teamdev.students.chat.model.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class ChatContext {
    private long numberOfMessages;
    private List<User> users= new LinkedList<User>();
    private List<Message> messages= new LinkedList<Message>();
    private List<String> colorsAvailable= new LinkedList<String>();
//    private Map<Long,User >= new LinkedHashMap<Long,User>();

    public void addUser(User user){
        users.add(user);
    }

    public void addMessage(Message mess){
        messages.add(mess);
        numberOfMessages++;
    }

    public User getUserById(long id){
       for(User us : users) {
           if(us.getUserId() == id)
               return us;
       }
        return null;
    }

    public Message getMessageById(long id){
        for(Message mess : messages) {
            if(mess.getMessageId() == id)
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
}
