package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Country;
import hauhc1203.webthueny.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;


    public List<Country> getAll(){
        return countryRepo.findAll();
    }
}
