package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Profile;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfileRepo extends PagingAndSortingRepository<Profile,Long> {
    Profile findByAppUserId(long id);
    Profile findById(long id);

    @Query(nativeQuery = true,value = "SELECT * FROM webthueny.profile where status=5 ORDER BY create_date DESC limit 12;")
    List<Profile> newccdv();
//    void  getProfileByIsConfirm(int i);

    @Query(nativeQuery = true,value = "SELECT p.id FROM webthueny.profile AS p JOIN app_user AS a WHERE  p.app_user_id=a.id and a.vip=true ORDER BY p.views LIMIT 6;")
    List<Long> listIDVipCCDV();

    Page<Profile> getAllByCityIdOrderByCreateDateDesc(int id, Pageable pageable);

}
