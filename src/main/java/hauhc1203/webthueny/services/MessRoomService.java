package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.MessageRoom;
import hauhc1203.webthueny.repository.MessageRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessRoomService {
    @Autowired
    MessageRoomRepo messageRoomRepo;
    @Autowired
    AppUserService appUserService;

    public MessageRoom save(MessageRoom messageRoom){
        return messageRoomRepo.save(messageRoom);
    }

    public MessageRoom getRoom(long id,long person2Id){

        return messageRoomRepo.getroomchat(id,person2Id);
    }
    public MessageRoom create(long person2Id){
        AppUser ps1=appUserService.getAppUserByUserDetail();
        AppUser ps2=appUserService.findById(person2Id);
        MessageRoom room=new MessageRoom();
        room.setPerson1(ps1);
        room.setPerson2(ps2);
        room.setRoom(ps1.getUserName()+"room"+ps2.getUserName());
        return save(room);

    }
    public List<MessageRoom> getAllRoom(){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        return messageRoomRepo.getAllRoom(appUser.getId());
    }

}
