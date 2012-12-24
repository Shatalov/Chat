package com.teamdev.students.chat.service;

import com.teamdev.students.chat.ChatContext;
import com.teamdev.students.chat.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnterUserService {

//    private static final Logger LOGGER = Logger.getLogger(EnterUserService.class);

    public boolean checkUniquenessName(ChatContext chatContext, String nickname){

        List<User> users = chatContext.getUsers();

        nickname = nickname.trim();
        if(nickname.equals(""))
            return false;

        for (User us : users) {
            if (nickname.equals(us.getNickName()))
                return false;
        }
        return true;
    }

    public User addNewUser(ChatContext chatContext, String nickname, String colorUser){

        long numberOfUsers = chatContext.getNumberOfUsers();
        User user = new User(numberOfUsers +1, nickname,
                chatContext.getNumberOfMessages(),
                colorUser);
        chatContext.addUser(user);

        return user;
    }
}
