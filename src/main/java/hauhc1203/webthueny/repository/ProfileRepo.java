package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.models.Profile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepo extends CrudRepository<Profile,Long> {
    Profile findByAppUserId(long id);

    Profile findById(long id);
    @Query(nativeQuery = true,value = "select * from profile where is_confirm = 1")
    List<Profile> getProfileByIsConfirm();
}
