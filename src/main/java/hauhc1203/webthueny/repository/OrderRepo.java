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

    @Query(nativeQuery = true,value = "select * from ordersss where done_from_user=true and done_fromccdv = true")
    List<Order> OrderSuccess();
    Order findById(long id);
    Page<Order> getAllByAppUserIdOrderByStatusAsc(long id, Pageable pageable);
    Page<Order> getAllByProfileIdOrderByStatusAsc(long id, Pageable pageable);

    @Query(nativeQuery = true,value = "select distinct ordersss.id from ordersss join reportsss on ordersss.id = reportsss.about_id ")
    List<Long> listid();

    @Query(nativeQuery = true,value = "select  sum(total) from ordersss where status = 4 and month(create_date) =:month and year(create_date) =:year ;")
    Double totalByMonth(int month,int year);

    @Query(nativeQuery = true,value = "select  sum(total) from ordersss where status = 4 ;")
    Double total();

}
