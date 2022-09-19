package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.MessageRoom;
import hauhc1203.webthueny.services.AppUserService;
import hauhc1203.webthueny.services.MessRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roomchat")
public class MessageRoomAPI {
    @Autowired
    MessRoomService messRoomService;
    @Autowired
    AppUserService appUserService ;


    @PostMapping
    public ResponseEntity<MessageRoom> create(@RequestBody MessageRoom messageRoom){
        return new ResponseEntity<>(messRoomService.save(messageRoom), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MessageRoom> getR(@PathVariable long id){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        return new ResponseEntity<>(messRoomService.getRoom(appUser.getId(),id),HttpStatus.OK);
    }

    @GetMapping("getallroom")
    public ResponseEntity<List<MessageRoom>> getAllRoom(){
        return new ResponseEntity<>(messRoomService.getAllRoom(),HttpStatus.OK);
    }

}
