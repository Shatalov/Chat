package com.teamdev.students.chat.service;

import com.teamdev.students.chat.model.Message;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService {

    private static final Logger LOGGER = Logger.getLogger(MessageService.class);

    /**
     * Finds the message by the ID provided
     *
     * @param messageId ID of the message to search for
     * @return the message with the given ID or null if no such message exists
     */
    public Message find(long messageId) {
        LOGGER.debug("Finding the message by ID = " + messageId);
        //todo[oleksii.tymchenko]: integrate with the real storage
        return new Message(messageId, "Message text", new Date(), 1L);
    }

    public void post(Message newMessage) {
        LOGGER.debug("New message has been posted: " + newMessage);
    }
}