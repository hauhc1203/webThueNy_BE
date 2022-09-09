package hauhc1203.webthueny.services;

import hauhc1203.webthueny.config.constant.AccountConst;
import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.models.ProvideService;
import hauhc1203.webthueny.models.Role;
import hauhc1203.webthueny.repository.ProvideServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProvideServiceS {
    @Autowired
    ProvideServiceRepo provideServiceRepo;
    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserService;

    public Set<ProvideService> getAllbyProfile(long id){
        Profile profile=profileService.findByAppUserID(id);
        return profile.getServiceList();
    }

    public List<ProvideService> getAll(){
        List<ProvideService> provideServices=(List<ProvideService>) provideServiceRepo.findAll();
        return provideServices;
    }

    public void registerService(double [] data){
       UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
       Profile profile=profileService.findByAppUserID(appUser.getId());

       Set<ProvideService> serviceList=new HashSet<>();
       int size=data.length-1;
       profile.setCost(data[size]);
        for (int i = 0; i < size; i++) {
            ProvideService provideService=new ProvideService();
            provideService.setId((int) data[i]);
            serviceList.add(provideService);
        }
        profile.setServiceList(serviceList);
        profileService.save(profile);


        Role role=new Role();
        role.setId(AccountConst.ROLE_CCDV);
        List<Role> roles=appUser.getRoles();
        roles.add(role);
        appUser.setRoles(roles);
        appUserService.save(appUser);

    }
}
