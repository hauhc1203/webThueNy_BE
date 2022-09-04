package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.repository.AppUserRepo;
import hauhc1203.webthueny.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    MailService mailService;
    @Autowired
    AppUserRepo appUserRepo;
    @Autowired
    ProfileRepo profileRepo;

    public List<AppUser> getAll(){
        return (List<AppUser>) appUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
        return appUserRepo.findAppUsersByUserName(username);
    }

    public AppUser findByEmail(String mail){
        return appUserRepo.findAppUsersByEmail(mail);
    }



    public AppUser save(AppUser user){
        AppUser appUser= appUserRepo.save(user);

        mailService.sendMail(appUser);

        Profile profile=new Profile();
        Date createDate =new Date();
        profile.setAppUser(appUser);
        profile.setCreateDate(createDate);

        profileRepo.save(profile);
        return appUser;


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findAppUsersByUserName(username);
        return new User(appUser.getUserName(),appUser.getPassWord(),appUser.getRoles());
    }
}

