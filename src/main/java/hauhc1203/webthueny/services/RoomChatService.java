package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.RoomChat;
import hauhc1203.webthueny.repository.RoomChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomChatService {
    @Autowired
    RoomChatRepo roomChatRepo;
    @Autowired
    AppUserService appUserService;

    public long getIdRoomChat(String send, String re) {
        RoomChat roomChat = roomChatRepo.findBySenderUserNameAndReceiverUserName(send, re);
        RoomChat roomChat1 = roomChatRepo.findBySenderUserNameAndReceiverUserName(send, re);
        if (roomChat != null) {
            return roomChat.getIdRoom();
        } else if (roomChat1 != null) {
            return roomChat1.getIdRoom();
        } else {
            return -1;
        }
    }
    public RoomChat save(String send,String re){
        RoomChat roomChat = new RoomChat();
        roomChat.setSender(appUserService.findByName(re));
        roomChat.setReceiver(appUserService.findByName(send));
        return roomChatRepo.save(roomChat);
    }
}
