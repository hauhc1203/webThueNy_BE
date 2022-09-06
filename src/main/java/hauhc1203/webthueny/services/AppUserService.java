package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.models.Role;
import hauhc1203.webthueny.models.Wallet;
import hauhc1203.webthueny.repository.AppUserRepo;
import hauhc1203.webthueny.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    WalletService walletService;
    public List<AppUser> getAll(){
        return (List<AppUser>) appUserRepo.findAll();
    }

    public AppUser findById(long id){
        return appUserRepo.findAppUsersById(id);
    }

    public AppUser findByUserName(String username){
        return appUserRepo.findAppUsersByUserName(username);
    }

    public AppUser findByEmail(String mail){
        return appUserRepo.findAppUsersByEmail(mail);
    }

    public List<AppUser > findByRoleUser(){
        return appUserRepo.getAppUserByRoles();
    }

    public AppUser save(AppUser user){
        Role role=new Role();
        role.setId(1);
//        Role role1=new Role();
//        role1.setId(2);
        List<Role> roles=new ArrayList<>();
        roles.add(role);
//        roles.add(role1);
        user.setRoles(roles);
        AppUser appUser= appUserRepo.save(user);
        mailService.sendMail(appUser);


        Profile profile=new Profile();
        Date createDate =new Date();
        profile.setAppUser(appUser);
        profile.setCreateDate(createDate);
        profileRepo.save(profile);

        Wallet wallet=new Wallet();
        wallet.setAppUser(appUser);
        wallet.setAmount(1000000000);
        walletService.save(wallet);

        return appUser;


    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findAppUsersByUserName(username);
        return new User(appUser.getUserName(),appUser.getPassWord(),appUser.getRoles());
    }

    public AppUser findByName(String name){
        return appUserRepo.findAppUsersByUserName(name);
    }


}

