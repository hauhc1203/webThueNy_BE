package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.ProvideService;
import org.springframework.data.repository.CrudRepository;

public interface ProvideServiceRepo extends CrudRepository<ProvideService,Long> {
//    @Query(nativeQuery = true,value = "SELECT se FROM profile as p JOIN profile_service_list AS ps on p.id=ps.profile_id JOIN service as s on ps.service_list_id=s.id")
}
