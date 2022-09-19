package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Message;
import hauhc1203.webthueny.models.MessageRoom;
import hauhc1203.webthueny.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepo messageRepo;


    public Message save(Message message){
        return messageRepo.save(message);
    }

    public List<Message> getMessByRoom(MessageRoom messageRoom){
        return messageRepo.getMByU(messageRoom.getPerson1().getId(), messageRoom.getPerson2().getId());
    }
}
