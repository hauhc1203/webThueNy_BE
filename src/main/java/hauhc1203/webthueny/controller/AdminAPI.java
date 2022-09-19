package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.config.constant.AccountConst;
import hauhc1203.webthueny.config.constant.ProfileConst;
import hauhc1203.webthueny.models.*;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.OrderService;
import hauhc1203.webthueny.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminAPI {
    static Order oderBad;
    @Autowired
    ProfileService profileService;
    @Autowired
    AppUserService appUserService;

    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<List<AppUser>> getAll(){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(appUserService.findByRoleUser(), HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<List<Profile>> getProfile(){
        return new ResponseEntity<>(profileService.getProfile(),HttpStatus.OK);
    }


    @GetMapping("/find/{name}")
    public AppUser findByName(@PathVariable String name){
        return appUserService.findByName(name);
    }

    @GetMapping("/ban/{id}")
    public ResponseEntity<AppUser> banUser(@PathVariable long id){
        AppUser appUser = appUserService.findById(id);
        appUser.setStatus(AccountConst.BANED);
        return new ResponseEntity<>(appUserService.save(appUser),HttpStatus.OK);
    }

    @GetMapping("/offline/{id}")
    public ResponseEntity<AppUser> offline(@PathVariable long id){
        AppUser appUser = appUserService.findById(id);
        appUser.setStatus(AccountConst.OFFLINE);
        return new ResponseEntity<>(appUserService.save(appUser),HttpStatus.OK);
    }

    @GetMapping("/vip/{id}")
    public ResponseEntity<AppUser> vip(@PathVariable long id){
        AppUser appUser = appUserService.findById(id);
        appUser.setVip(true);
        return new ResponseEntity<>(appUserService.save(appUser),HttpStatus.OK);
    }

    @GetMapping("/unvip/{id}")
    public ResponseEntity<AppUser> unvip(@PathVariable long id){
        AppUser appUser = appUserService.findById(id);
        appUser.setVip(false);
        return new ResponseEntity<>(appUserService.save(appUser),HttpStatus.OK);
    }

    @GetMapping("/showOrder")
    public ResponseEntity<List<Order>> showOder(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/showOder/{id}")
    public ResponseEntity<Order>  showOderDetail(@PathVariable long id){
        oderBad=orderService.findById(id);
        return new ResponseEntity<>(orderService.findById(id),HttpStatus.OK);
    }
@GetMapping("/showOderBad")
public ResponseEntity<Order>  showOderBad(){
    return new ResponseEntity<>(oderBad,HttpStatus.OK);
}


    @GetMapping("/uservalidation/{id}")
    public ResponseEntity<Profile> userValidation(@PathVariable long id){
        Profile profile = profileService.findById(id);
        profile.setIsConfirm(ProfileConst.REGISTER_PROVIDE_SERVICE_SUCCESS);
        return new ResponseEntity<>(profileService.save(profile),HttpStatus.OK);

    }

    @PostMapping("/refuse/{id}")
    public ResponseEntity<Profile> refuse(@PathVariable long id,@RequestBody String mess){
        Profile profile = profileService.findById(id);
        profile.setIsConfirm(ProfileConst.REGISTER_PROVIDE_SERVICE_FAILED);
        profile.setMessFromAdmin(mess);
        return new ResponseEntity<>(profileService.save(profile),HttpStatus.OK);
    }

    @GetMapping("resetrole")
    public void rsRole(){
        AppUser appUser=appUserService.findById(18);
        List<Role>roles=  new ArrayList<>();
        Role role=new Role();
        role.setId(AccountConst.ROLE_USER);
        roles.add(role);
        appUser.setRoles(roles);
        appUserService.save(appUser);
    }

    @GetMapping("/ordersuccess")
    public ResponseEntity<List<Order>> orderSuccess(){
        return new ResponseEntity<>(orderService.orderSuccess(),HttpStatus.OK);
    }

    @GetMapping("/orderbad")
    public ResponseEntity<List<Order>> orderBad(){
        return new ResponseEntity<>(orderService.getAllbadO(),HttpStatus.OK);
    }


}
