package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Role;
import hauhc1203.webthueny.models.dto.UserToken;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.JwtService;
import hauhc1203.webthueny.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class LoginAPI {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Autowired
    AppUserService appUserService;

    @PostMapping("/login")
    public UserToken login(@RequestBody AppUser appUser){
        try{
            // Tao ra 1 doi tuong Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(appUser.getUserName(),appUser.getPassWord()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            AppUser appUser1 = appUserService.findByUserName(appUser.getUserName());

            return new UserToken(appUser1.getId(),appUser1.getUserName(),token,appUser1.getRoles());
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<AppUser> findByUserName(@PathVariable String name){
        return new ResponseEntity<>(appUserService.findByUserName(name), HttpStatus.OK);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<AppUser> findByEmail(@PathVariable String email){
        System.out.println("email"+ appUserService.findByEmail(email));
        return new ResponseEntity<>(appUserService.findByEmail(email),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
            String pass = passwordEncoder.encode(appUser.getPassWord());
            appUser.setPassWord(pass);
            return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);


    }


}
