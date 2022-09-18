package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Feedback;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FeedBackRepo extends PagingAndSortingRepository<Feedback,Long> {

    List<Feedback> findAllByOrderId(long id);


}
