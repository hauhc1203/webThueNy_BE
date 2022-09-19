package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Message;

import hauhc1203.webthueny.models.MessageRoom;
import hauhc1203.webthueny.models.dto.MaR;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.MessRoomService;
import hauhc1203.webthueny.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class MessageAPI {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    MessRoomService messRoomService;

    @Autowired
    AppUserService appUserService;
    @Autowired
    MessageService messageService;

    @MessageMapping("/newrqchat")
    public void greeting(MessageRoom messageRoom) throws Exception {
        AppUser recv =appUserService.findById(messageRoom.getPerson2().getId());
        String dess="/notification/"+recv.getUserName();
        simpMessagingTemplate.convertAndSend(dess,messageRoom );
    }


    @MessageMapping("/private")
    public void privateMess(MaR message) throws Exception {
        Message message1=new Message();
        message1.setContent(message.getContent());
        message1.setSender(message.getSender());
        message1.setReceiver(message.getReceiver());
        Date now =new Date();
        message1.setTime(now);

        String destination="/private/"+message.getRoom();
        simpMessagingTemplate.convertAndSend(destination, messageService.save(message1));
    }

    @PostMapping("/getMbyR")
    public ResponseEntity<List<Message>> getM(@RequestBody MessageRoom messageRoom){
        return new ResponseEntity<>(messageService.getMessByRoom(messageRoom), HttpStatus.OK);
    }

}
