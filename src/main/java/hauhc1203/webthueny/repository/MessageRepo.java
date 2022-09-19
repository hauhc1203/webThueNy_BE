package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends PagingAndSortingRepository<Message,Long> {

        @Query(nativeQuery = true,value = "SELECT * FROM webthueny.message where sender_id=:id1 and receiver_id=:id2 or sender_id=:id2 and receiver_id=:id1 ORDER BY time Asc")
        List<Message> getMByU(@Param("id1") long id1, @Param("id2") long id2);



}
