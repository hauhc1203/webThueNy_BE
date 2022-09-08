package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.ProvideService;
import hauhc1203.webthueny.services.ProvideServiceS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
@CrossOrigin("*")
public class ProvideServiceAPI {
    @Autowired
    ProvideServiceS provideServiceS;

    @GetMapping
    public ResponseEntity<List<ProvideService>> getAll(){
        return new ResponseEntity<>(provideServiceS.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public void registerService(@RequestBody double[] data){
       provideServiceS.registerService(data);
    }
}
