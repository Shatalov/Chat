package com.teamdev.students.chat.service;

import com.teamdev.students.chat.ChatContext;

import com.teamdev.students.chat.controller.dto.MessagePostRequest;
import com.teamdev.students.chat.controller.dto.MessageResponse;
import com.teamdev.students.chat.model.Message;
import com.teamdev.students.chat.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageService {

    private static final Logger LOGGER = Logger.getLogger(MessageService.class);

    /**
     * Finds the message by the ID provided
     *
     * @param userId ID of the message to search for
     * @return the message with the given ID or null if no such message exists
     */
    public MessageResponse getMessagesForUser(ChatContext chatContext, long userId) {
        LOGGER.debug("Finding the user by ID = " + userId);

        MessageResponse messResp = null;

        User user = chatContext.getUserById(userId);
        long numberOfShownMessages = 0L;
        numberOfShownMessages =user.getNumberOfShownMessages();
        long numberOfMessages = chatContext.getNumberOfMessages();

//        for(long i = numberOfShownMessages; i <= numberOfMessages ;i++) {
//
//        }

        if(numberOfShownMessages <= numberOfMessages) {
            Message mess = chatContext.getMessageById(numberOfShownMessages);
            user.addNumberOfShownMessages();

            String colorText = "<div style= color:"+user.getUserColor() +">" + mess.getText() + "</div>";

            if(mess.isToAll()) {
                messResp = new MessageResponse(colorText,
                        mess.isToAll(),
                        findUserNameById(chatContext, mess.getUserId()), "");
            }  else{
                messResp = new MessageResponse(colorText,
                        mess.isToAll(),
                        findUserNameById(chatContext, mess.getUserId()),
                        findUserNameById(chatContext, mess.getToUserId()));
            }
         }

        return messResp;
    }

    private String findUserNameById(ChatContext chatContext, long userId){
            User user = chatContext.getUserById(userId);
           return  user.getNickName();
    }

    public void post(ChatContext chatContext, MessagePostRequest newMessage) {

        long numberOfMessages = chatContext.getNumberOfMessages();


        Message mess = new Message(
                newMessage.getText(),
                newMessage.isToAll(),
                newMessage.getToUserId(),
                numberOfMessages +1,
                new Date(),
                newMessage.getUserId());

        chatContext.addMessage(mess);

        LOGGER.debug("New message has been posted: " + newMessage);
    }
}
