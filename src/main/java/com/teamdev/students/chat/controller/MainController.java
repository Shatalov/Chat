package com.teamdev.students.chat.controller;

import com.teamdev.students.chat.ChatContext;
import com.teamdev.students.chat.controller.dto.MessagePostRequest;
import com.teamdev.students.chat.controller.dto.MessageResponse;
import com.teamdev.students.chat.model.Message;
import com.teamdev.students.chat.model.User;
import com.teamdev.students.chat.service.EnterUserService;
import com.teamdev.students.chat.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;

@Controller
public class MainController {

    private static final Logger LOGGER = Logger.getLogger(MainController.class);

    @Inject
    private MessageService messageService;
    @Inject
    private EnterUserService enterUserService;
    @Autowired
    private ChatContext chatContext;


    @RequestMapping(value = "/messages/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MessageResponse getMessage(@PathVariable("id") long messageId) {
        LOGGER.debug("Obtaining message for ID: " + messageId);
        Message message = messageService.find(messageId);
        LOGGER.debug("Message found: " + message);
        return toReponse(message);
    }

    @RequestMapping(value = "/messages/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postMessage(@RequestBody MessagePostRequest request) {
        LOGGER.debug("Got post message request: " + request);
        messageService.post(fromRequest(request));
    }

    //todo[...]: move to the separate Utility class
    private static Message fromRequest(MessagePostRequest request) {
        return new Message((long) 111, request.getText(), new Date(), request.getUserId(), false, 0);
    }

    private static MessageResponse toReponse(Message message) {
        return new MessageResponse(message.getText(), message.getUserId());
    }

    //    @RequestMapping(value = "/userNickName", method = RequestMethod.GET)
    @RequestMapping(value = "/user.form", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String enterUser(@RequestParam("nickName") String nickname,
                            @RequestParam("colorSelected") String colorUser,
                            Model model) {

        if(enterUserService.checkUniquenessName(chatContext, nickname)) {

            User user = enterUserService.addNewUser(chatContext, nickname, colorUser);
            model.addAttribute("userID", user.getUserId());

            LOGGER.debug("Get nickname: " + nickname);

            return "WEB-INF/jsp/messages.jsp";
        }
        else{
            String errorMessage = "Your nickName isn't uniqueness. Enter the other.";

            model.addAttribute("userNick", nickname);
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("colors", chatContext.getColorsAvailable());

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
        model.addAttribute("colors", chatContext.getColorsAvailable());
        model.addAttribute("errorMessage", errorMessage);

        LOGGER.debug("We are in first conroller");

        return "WEB-INF/jsp/enterChat.jsp";
    }

}
