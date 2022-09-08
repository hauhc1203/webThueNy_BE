package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepo profileRepo;


    public Profile findByAppUserID(long id){
        return profileRepo.findByAppUserId(id);
    }

    public void save (Profile profile){

        Profile profile1=  profileRepo.save(profile);
        System.out.println(profile1);
    }
}
