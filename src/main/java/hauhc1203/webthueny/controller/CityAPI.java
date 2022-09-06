package hauhc1203.webthueny.controller;

import hauhc1203.webthueny.models.City;
import hauhc1203.webthueny.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
@CrossOrigin("*")
public class CityAPI {
    @Autowired
    CityRepo cityRepo;

    @GetMapping("/{id}")
    public ResponseEntity<List<City>> getAllByCountry(@PathVariable int id){
        return new ResponseEntity<>(cityRepo.getAllByCountry_Id(id), HttpStatus.OK);
    }
}
