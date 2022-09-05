package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.Profile;
import hauhc1203.webthueny.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    public void save(Profile profile) {
        profileRepo.save(profile);
    }

    public Profile findByName(String name) {
        return profileRepo.findByAppUserUserName(name);

    }
}
