package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@CrossOrigin("*")
public class ProfileController {

    @Autowired
    ProfileService profileService;



    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable long id){
        return new ResponseEntity<>(profileService.findByAppUserID(id), HttpStatus.OK);
    }


}
