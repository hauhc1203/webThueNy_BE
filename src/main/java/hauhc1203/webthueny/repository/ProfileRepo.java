package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.City;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.models.Profile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

import java.util.List;

public interface ProfileRepo extends CrudRepository<Profile,Long> {
    Profile findByAppUserId(long id);

    Profile findById(long id);
    @Query(nativeQuery = true,value = "select * from profile where is_confirm = 1")
    List<Profile> getProfileByIsConfirm();

    @Query(nativeQuery = true,value = "SELECT * FROM webthueny.profile where status=5 ORDER BY create_date DESC limit 12;")
    List<Profile> newccdv();
//    void  getProfileByIsConfirm(int i);

    @Query(nativeQuery = true,value = "SELECT p.id FROM webthueny.profile AS p JOIN app_user AS a WHERE  p.app_user_id=a.id and a.vip=true ORDER BY p.views LIMIT 6;")
    List<Long> listIDVipCCDV();

    Page<Profile> getAllByCityIdOrderByCreateDateDesc(int id, Pageable pageable);

    @Query(nativeQuery = true,value = "SELECT * FROM webthueny.profile where gender=0 and status = 5 ")
    Page<Profile> female(Pageable pageable);

    @Query(nativeQuery = true,value = "SELECT * FROM webthueny.profile where gender=1 and status = 5")
    Page<Profile> male(Pageable pageable);

    @Query(nativeQuery = true,value = "select *\n" +
            "from profile\n" +
            "where (:full_name ='' or full_name like "+"%"+":full_name"+"%)\n" +
            "  and (:birth_day ='' or birth_day like "+"%"+":birth_day"+"%)\n" +
            "  and (:gender = '' or gender = :gender)\n" +
            "  and (:city_id ='' or city_id = :city_id)\n" +
            "  and (:views ='' or views >= :views);")
    List<Profile> search (@Param("full_name")String full_name,
                          @Param("birth_day")String birth_day,
                          @Param("gender")Boolean gender,
                          @Param("city_id") long city_id,
                          @Param("views")long views);

}
