package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.RoomChat;
import org.springframework.data.repository.CrudRepository;

public interface RoomChatRepo extends CrudRepository<RoomChat, Long> {
    RoomChat findBySenderUserNameAndReceiverUserName(String sender,String receiver);
}
