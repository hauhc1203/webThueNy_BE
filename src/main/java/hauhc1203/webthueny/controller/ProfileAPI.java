package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.OrderService;
import hauhc1203.webthueny.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Profile profile=profileService.findByAppUserID(id);
        profile.setViews(profile.getViews()+1);
        profileService.save(profile);
        return new ResponseEntity<>(profile, HttpStatus.OK);
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

        profileService.edit(profile);

    }

    @GetMapping("/orderByUser/{id}")
    public ResponseEntity<List<Order>> getByIdAppUser(@PathVariable long id){
        return new ResponseEntity<>(profileService.getOrderByAppUser(id),HttpStatus.OK);
    }

    @GetMapping("reqVerification/{id}")
    public void reqVerification(@PathVariable long id){
        profileService.reqVerification(id);
    }

    @PostMapping("editprice")
    public ResponseEntity<Profile> editP(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.editPrice(profile.getCost()),HttpStatus.OK);
    }

    @PostMapping("editrqm")
    public ResponseEntity<Profile> editrqm(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.editrqm(profile.getRequirementsForHirer()),HttpStatus.OK);
    }
    @GetMapping("newccdv")
    public ResponseEntity<List<Profile>> newccdv(){
        return new ResponseEntity<>(profileService.newccdv(),HttpStatus.OK);
    }
    @GetMapping("vipccdv")
    public ResponseEntity<List<Profile>> vipccdv(){
        return new ResponseEntity<>(profileService.vipCCdv(),HttpStatus.OK);
    }
    @GetMapping("nearccdv")
    public ResponseEntity<Page<Profile>> near(@RequestParam int page){
        return new ResponseEntity<>(profileService.nearCCDV(PageRequest.of(page,12)),HttpStatus.OK);
    }
}
