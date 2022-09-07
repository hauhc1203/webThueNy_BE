package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.City;
import hauhc1203.webthueny.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    CityRepo cityRepo;

    public List<City> getAllbyCountry(int id){
        return cityRepo.getAllByCountry_Id(id);
    }


}
