package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.Country;
import hauhc1203.webthueny.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("country")
@CrossOrigin("*")
public class CountryAPI {
    @Autowired
    CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getAll(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }



}
