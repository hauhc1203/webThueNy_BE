package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin("*")
public class ProfileAPI {

    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserService;


    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable long id){
        return new ResponseEntity<>(profileService.findByAppUserID(id), HttpStatus.OK);
    }
    @PostMapping("/img1")
    public  void saveIMG1(@RequestBody String img1){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
        Profile profile=profileService.findByAppUserID(appUser.getId());
        profile.setImg1(img1);
        profileService.save(profile);
    }
    @PostMapping("/img2")
    public  void saveIMG2(@RequestBody String img1){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
        Profile profile=profileService.findByAppUserID(appUser.getId());
        profile.setImg2(img1);
        profileService.save(profile);
    } @PostMapping("/img3")
    public  void saveIMG3(@RequestBody String img1){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
        Profile profile=profileService.findByAppUserID(appUser.getId());
        profile.setImg3(img1);
        profileService.save(profile);
    } @PostMapping("/avatar")
    public  void saveAvatar(@RequestBody String img1){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
        Profile profile=profileService.findByAppUserID(appUser.getId());
        profile.setAvatar(img1);
        profileService.save(profile);
    }
    @PostMapping("/edit")
    public void edit(@RequestBody Profile profile){
        UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser=appUserService.findByUserName(userDetails.getUsername());
        Profile profiles=profileService.findByAppUserID(appUser.getId());
        profile.setAppUser(appUser);
//        profile.setAvatar(profiles.getAvatar());
//        profile.setImg1(profiles.getImg1());
//        profile.setImg2(profiles.getImg2());
//        profile.setImg3(profiles.getImg3());
        profileService.save(profile);

    }
}
