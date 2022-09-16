package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Message;
import hauhc1203.webthueny.models.RoomChat;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.MessageService;
import hauhc1203.webthueny.services.RoomChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin("*")
public class ChatAPI {
    private Long idRomChat;
    RoomChat roomChat;
 @Autowired
 AppUserService appUserService;
 @Autowired
   SimpMessagingTemplate simpMessagingTemplate;
 @Autowired
   MessageService messageService;
 @Autowired
    RoomChatService roomChatService;
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload Message message){
        AppUser appUser = appUserService.findByName(message.getReceiver().getUserName());
        Message message1 = new Message();
        message1.setReceiver(appUser);
        message1.setRoomChat(roomChat);
        Date date = new Date();
        message.setTime(date);
        messageService.save(message);
        simpMessagingTemplate.convertAndSend("/topic/public/"+this.idRomChat,message.getReceiver()+":"+message.getContent());

    }



}
