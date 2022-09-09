package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.config.constant.AccountConst;
import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Order;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminAPI {
    @Autowired
    AppUserService appUserService;

    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<List<AppUser>> getAll(){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(appUserService.findByRoleUser(), HttpStatus.OK);
    }


    @GetMapping("/find/{name}")
    public AppUser findByName(@PathVariable String name){
        return appUserService.findByName(name);
    }

    @GetMapping("/ban/{id}")
    public ResponseEntity<AppUser> banUser(@PathVariable long id){
        System.out.println("ddddddddddddddddddddddddd" +id);
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


}
