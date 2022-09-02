package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findAppUsersByUserName(String userName);
    AppUser findAppUsersByEmail(String email);
}
