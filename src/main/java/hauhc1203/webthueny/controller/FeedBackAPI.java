package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Feedback;
import hauhc1203.webthueny.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("feedback")
public class FeedBackAPI {
    @Autowired
    FeedBackService feedBackService;


    @PostMapping
    public ResponseEntity<Feedback> create(@RequestBody Feedback feedback){
            return new ResponseEntity<>(feedBackService.create(feedback), HttpStatus.OK);
    }

    @GetMapping("/{orderid}")
    public ResponseEntity<List<Feedback>> create(@PathVariable long orderid){
        return new ResponseEntity<>(feedBackService.findByOrder(orderid), HttpStatus.OK);
    }


}
