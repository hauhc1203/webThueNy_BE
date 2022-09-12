package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Profile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProfileRepo extends PagingAndSortingRepository<Profile,Long> {
    Profile findByAppUserId(long id);
    @Query(nativeQuery = true,value = "SELECT * FROM profile order by views desc limit 6")
    List<Profile>getProfileByViews();

}
