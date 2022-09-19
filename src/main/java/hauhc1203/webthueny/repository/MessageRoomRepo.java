package hauhc1203.webthueny.repository;


import hauhc1203.webthueny.models.MessageRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRoomRepo  extends JpaRepository<MessageRoom,Long> {
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM webthueny.message_room WHERE person1_id=:id1 and person2_id=:id2 \n" +
                    "UNION \n" +
                    "SELECT * FROM webthueny.message_room WHERE person1_id=:id2 and person2_id=:id1")
    MessageRoom getroomchat(@Param("id1") long id1,
                            @Param("id2") long id2);
    @Query(nativeQuery = true,value = "SELECT * FROM message_room WHERE person1_id=:idU OR person2_id=:idU")
    List<MessageRoom> getAllRoom(@Param("idU") long idU);
}
