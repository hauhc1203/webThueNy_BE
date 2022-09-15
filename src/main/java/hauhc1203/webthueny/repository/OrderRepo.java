package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepo extends PagingAndSortingRepository<Order,Long> {
    Order findOrderById (long id);

    @Query(nativeQuery = true,value = "select * from ordersss where app_user_id=:id")
    List<Order> OrderByAppUser(@Param("id")long id);
    Order findById(long id);
    Page<Order> getAllByAppUserIdOrderByStatusAsc(long id, Pageable pageable);
    Page<Order> getAllByProfileIdOrderByStatusAsc(long id, Pageable pageable);

}
