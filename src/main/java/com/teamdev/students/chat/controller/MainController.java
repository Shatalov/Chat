package com.teamdev.students.chat.controller;

import com.teamdev.students.chat.ChatContext;
import com.teamdev.students.chat.controller.dto.MessagePostRequest;
import com.teamdev.students.chat.controller.dto.MessageResponse;
import com.teamdev.students.chat.controller.dto.UserResponse;
import com.teamdev.students.chat.model.Color;
import com.teamdev.students.chat.model.User;
import com.teamdev.students.chat.service.MessageService;
import com.teamdev.students.chat.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@Controller
public class MainController {

    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    @Inject
    private MessageService messageService;
    @Inject
    private UserService userService;
    @Autowired
    private ChatContext chatContext;


    @RequestMapping(value = "/messages/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MessageResponse getMessage(@PathVariable("userId") long userId) {
        if (userId != 0) {
            LOGGER.debug("Obtaining message for user with ID: " + userId);
            MessageResponse messageResp = messageService.getMessagesForUser(chatContext, userId);

            LOGGER.debug("Message found: " + messageResp);

            return messageResp;
        }
        return null;
    }

    @RequestMapping(value = "/messages/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postMessage(@RequestBody MessagePostRequest messagePost) {
        LOGGER.debug("Got post message request: " + messagePost);

        messageService.post(chatContext, messagePost);

    }

    @RequestMapping(value = "/messages/users/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<UserResponse> getUsers(@PathVariable("userId") long userId) {
        if (userId != 0) {
            LOGGER.debug("Getting users for user with ID: " + userId);

            List<UserResponse> listUsersResp = userService.getUsersExceptOne(chatContext, userId);

            return listUsersResp;
        }
        return null;
    }


    @RequestMapping(value = "/user.form", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String enterUser(@RequestParam("nickName") String nickname,
                            @RequestParam("colorSelected") Color colorUser,
                            Model model) {

        if (userService.checkUniquenessName(chatContext, nickname)) {

            User user = userService.addNewUser(chatContext, nickname, colorUser);
            model.addAttribute("userID", user.getIdUser());

            LOGGER.debug("Get nickname: " + nickname);

            return "WEB-INF/jsp/messages.jsp";
        } else {
            String errorMessage = "Your nickName isn't uniqueness. Enter the other.";

            model.addAttribute("userNick", nickname);
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("colors", Color.values());

            LOGGER.debug("isn't uniqueness nickname: " + nickname);

            return "WEB-INF/jsp/enterChat.jsp";
        }
    }

    @RequestMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String enterUser(Model model) {

        String userNick = "";
        String errorMessage = "";

        model.addAttribute("userNick", userNick);
        model.addAttribute("colors", Color.values());
        model.addAttribute("errorMessage", errorMessage);

        LOGGER.debug("We are in first conroller");

        return "WEB-INF/jsp/enterChat.jsp";
    }

}
