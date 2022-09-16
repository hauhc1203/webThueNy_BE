package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message,Long> {
    List<Message> findAllByRoomChatIdRoom(long idRoom);
}
