package hauhc1203.webthueny.services;

import hauhc1203.webthueny.config.constant.ProfileConst;
import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.repository.OrderRepo;
import hauhc1203.webthueny.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    AppUserService appUserService;

    public Profile findById(long id){
        return profileRepo.findById(id);
    }



    public Profile findByAppUserID(long id){
        return profileRepo.findByAppUserId(id);
    }



    public Profile save (Profile profile){

        return profileRepo.save(profile);
    }
    public void edit(Profile profile){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
        Profile profile1=findByAppUserID(appUser.getId());
        profile1.setBirthDay(profile.getBirthDay());
        profile1.setFullName(profile.getFullName());
        profile1.setWeight(profile.getWeight());
        profile1.setHigh(profile.getHigh());
        profile1.setCity(profile.getCity());
        profile1.setCountry(profile.getCountry());
        profile1.setHobby(profile.getHobby());
        profile1.setIntroduction(profile.getIntroduction());
        profile1.setFacebookLink(profile.getFacebookLink());
        profile1.setGender(profile.isGender());

        save(profile1);

    }

    public List<Order> getOrderByAppUser(long id){
        return orderRepo.OrderByAppUser(id);
    }
    public void reqVerification(long id){
        Profile profile=profileRepo.findByAppUserId(id);
        profile.setIsConfirm(ProfileConst.REQUEST_CONFIRM_PROFILE);
        save(profile);
    }

    public Profile editPrice(double price){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        Profile profile=findByAppUserID(appUser.getId());
        profile.setCost(price);
        return save(profile);
    }

    public Profile editrqm(String rqm){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        Profile profile=findByAppUserID(appUser.getId());
        profile.setRequirementsForHirer(rqm);
        return save(profile);
    }

    public List<Profile> getProfile(){
        return profileRepo.getProfileByIsConfirm();
    }


}
