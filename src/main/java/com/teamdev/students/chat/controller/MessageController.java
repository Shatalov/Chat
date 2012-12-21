package com.teamdev.students.chat.controller;

import com.teamdev.students.chat.controller.dto.MessagePostRequest;
import com.teamdev.students.chat.controller.dto.MessageResponse;
import com.teamdev.students.chat.model.Message;
import com.teamdev.students.chat.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Date;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private static final Logger LOGGER = Logger.getLogger(MessageController.class);

    @Inject
    private MessageService messageService;

    @RequestMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MessageResponse getMessage(@PathVariable("id") long messageId) {
        LOGGER.debug("Obtaining message for ID: " + messageId);
        Message message = messageService.find(messageId);
        LOGGER.debug("Message found: " + message);
        return toReponse(message);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postMessage(@RequestBody MessagePostRequest request) {
        LOGGER.debug("Got post message request: " + request);
        messageService.post(fromRequest(request));
    }

    //todo[...]: move to the separate Utility class
    private static Message fromRequest(MessagePostRequest request) {
        return new Message(null, request.getText(), new Date(), request.getUserId());
    }

    private static MessageResponse toReponse(Message message) {
        return new MessageResponse(message.getText(), message.getUserId());
    }
}
