package hauhc1203.webthueny.repository;

import hauhc1203.webthueny.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepo extends JpaRepository<City,Integer> {

    List<City> getAllByCountry_Id(int id);
}
