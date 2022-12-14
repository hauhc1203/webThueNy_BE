package hauhc1203.webthueny.services;

import hauhc1203.webthueny.config.constant.ProfileConst;
import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.City;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.repository.OrderRepo;
import hauhc1203.webthueny.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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

        AppUser appUser=appUserService.getAppUserByUserDetail();
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
    public List<Profile> newccdv(){
        return profileRepo.newccdv();
    }
    public List<Profile> vipCCdv(){
        List<Profile> profiles=new ArrayList<>();
        List<Long> listId=profileRepo.listIDVipCCDV();
        for (long id:listId
             ) {
            profiles.add(profileRepo.findById(id));
        }
        return profiles;
    }

    public Page<Profile> nearCCDV(Pageable pageable){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        Profile profile=profileRepo.findByAppUserId(appUser.getId());
        return profileRepo.getAllByStatusAndCityIdOrderByCreateDateDesc(5,profile.getCity().getId() ,pageable);
    }

    public List<Profile> getProfile(){
        return profileRepo.getProfileByIsConfirm();
    }
    public List<Profile>getUserBoy(){
        return profileRepo.showListBoy();
    }
    public List<Profile>getUserGirl(){
        return profileRepo.showListGirl();
    }



    public Page<Profile> showByGender(Pageable pageable){
        AppUser appUser = appUserService.getAppUserByUserDetail();
        Profile profile = profileRepo.findByAppUserId(appUser.getId());

        if (profile.isGender()==true){
            return profileRepo.female(pageable);
        } else {
            return profileRepo.male(pageable);
        }
    }

    public List<Profile> search(String name,int minAge,int maxAge, String gender, String city, String views,String hireTimes){
        Boolean gender1;
        if(name==""||name==null){
            name=null;
        }else {
            name="%"+name+"%";
        }
        if(gender==""||gender==null){
            gender1=null;
        }else {
             gender1= Boolean.parseBoolean(gender);
        }

        if(city==""){
            city=null;
        }
        if(views==""){
            views=null;
        }
        if(hireTimes==""){
            hireTimes=null;
        }
        Date date=new Date();
        int year=date.getYear()+1900;
            int minY=year-maxAge;
            int maxY=year-minAge;
        return  profileRepo.search(name,String.valueOf(minY),String.valueOf(maxY),gender1,city,views,hireTimes);
    }

    public List<Profile> getALl(){
        return (List<Profile>) profileRepo.findAll();
    }

    public List<Profile> ccdvGetAll(){
        return profileRepo.ccdv();
    }

    public List<Profile>getlistp(List<Long> list){
        List<Profile> list1=new ArrayList<>();
        for (Long id: list
             ) {
            list1.add(findByAppUserID(id));
        }
        return list1;
    }
}
