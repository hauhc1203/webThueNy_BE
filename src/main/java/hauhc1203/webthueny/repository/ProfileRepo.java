package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.Profile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepo extends PagingAndSortingRepository<Profile,Long> {
    Profile findByAppUserUserName(String name);
}
