package com.teamdev.students.chat.service;

import com.teamdev.students.chat.ChatContext;
import com.teamdev.students.chat.controller.dto.UserResponse;
import com.teamdev.students.chat.model.Color;
import com.teamdev.students.chat.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {

    public boolean checkUniquenessName(ChatContext chatContext, String nickname) {

        List<User> users = chatContext.getUsers();

        nickname = nickname.trim();
        if (nickname.equals(""))
            return false;

        for (User us : users) {
            if (nickname.equals(us.getNickName()))
                return false;
        }
        return true;
    }

    public List<UserResponse> getUsersExceptOne(ChatContext chatContext, long userId) {
        List<UserResponse> listUsersResp = new LinkedList<UserResponse>();

        for (User us : chatContext.getUsers()) {
            if (us.getIdUser() != userId) {
                listUsersResp.add(
                        new UserResponse(us.getIdUser(), us.getNickName()));
            }
        }
        return listUsersResp;
    }

    public User addNewUser(ChatContext chatContext, String nickname, Color colorUser) {

        long numberOfUsers = chatContext.getNumberOfUsers();
        User user = new User(numberOfUsers + 1, nickname,
                chatContext.getNumberOfMessages(),
                colorUser);
        chatContext.addUser(user);

        return user;
    }
}
