package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Message;
import hauhc1203.webthueny.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;
    public List<Message> getAllByIdRoom(long idRoomChat){
        return messageRepo.findAllByRoomChatIdRoom(idRoomChat);
    }
    public void save(Message message){
        messageRepo.save(message);
    }
}
