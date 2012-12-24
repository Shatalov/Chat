package com.teamdev.students.chat.controller;

import com.teamdev.students.chat.ChatContext;
import com.teamdev.students.chat.controller.dto.MessagePostRequest;
import com.teamdev.students.chat.controller.dto.MessageResponse;
import com.teamdev.students.chat.model.Color;
import com.teamdev.students.chat.model.Message;
import com.teamdev.students.chat.model.User;
import com.teamdev.students.chat.service.EnterUserService;
import com.teamdev.students.chat.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
        return new Message((long)111, request.getText(), new Date(), request.getUserId());
    }

    private static MessageResponse toReponse(Message message) {
        return new MessageResponse(message.getText(), message.getUserId());
    }

//    @RequestMapping(value = "/userNickName", method = RequestMethod.GET)
    @RequestMapping(value = "/user.form", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String enterUser(@RequestParam("nickName") String nickname, Model model){

       User user =  new User(333, "Yar");
       model.addAttribute("user", user);
        model.addAttribute("userIDDDD", "dddddddddddd");

        LOGGER.debug("Get nickname: " + nickname);

        System.out.println("***************Get nickname: " + nickname);

        return "WEB-INF/jsp/messages.jsp";
//         return "messages";
    }
    @RequestMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public String enterUser( Model model){

        User user =  new User(0, "");
        List<Color> col= new LinkedList<Color>();
        col.add(new Color("Black"));
        col.add(new Color("Green"));
        col.add(new Color("Brown"));

        chatContext.setColorsAvailable(col);

        model.addAttribute("user", user);
        model.addAttribute("colors", chatContext.getColorsAvailable());
//        model.addAttribute("colors", chatContext);

//        LOGGER.debug("Get nickname: " + nickname);
//
//        System.out.println("***************Get nickname: " + nickname);

        return "WEB-INF/jsp/enterChat.jsp";
//         return "messages";
    }

}
