package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepo extends CrudRepository<AppUser,Long> {
    AppUser findAppUsersByUserName(String userName);
    AppUser findAppUsersByEmail(String email);

    @Query(nativeQuery = true,value = "select * from app_user join app_user_roles on app_user.id=app_user_roles.app_user_id where roles_id=1")
    List<AppUser> getAppUserByRoles();

    AppUser findAppUsersById(long id);
}
