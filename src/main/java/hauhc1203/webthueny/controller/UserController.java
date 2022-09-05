package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    AppUserService appUserService;

    @GetMapping
    public ResponseEntity<List<AppUser>> getAll(){
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{name}")
    public AppUser findByName(@PathVariable String name){
        return appUserService.findByName(name);
    }


}
