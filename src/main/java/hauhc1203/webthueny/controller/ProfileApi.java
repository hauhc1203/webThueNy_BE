package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileApi {
    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserService;
    @PostMapping
    public void save(@RequestBody Profile profile){
        profileService.save(profile);
    }
    @GetMapping("/profile")
    public Profile finbyId(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return profileService.findByName(appUser.getUserName());
    }
    @PostMapping("/editAvarta")
    public void edit(@RequestBody String avatar){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        Profile profile =  profileService.findByName(appUser.getUserName());
        profile.setAvatar(avatar);
        profileService.save(profile);
    }
}
