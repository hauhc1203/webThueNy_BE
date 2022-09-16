package hauhc1203.webthueny.services;

import hauhc1203.webthueny.models.AppUser;
import hauhc1203.webthueny.models.Feedback;
import hauhc1203.webthueny.repository.FeedBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackService {
    @Autowired
    FeedBackRepo feedBackRepo;

    @Autowired
    AppUserService appUserService;
    public List<Feedback> findByOrder(long id){
        return feedBackRepo.findAllByOrderId(id);
    }

    public Feedback findByID(long id){
        return feedBackRepo.findById(id).get();
    }

    public Feedback save(Feedback feedback){
        return feedBackRepo.save(feedback);
    }

    public Feedback create(Feedback feedback){
        AppUser appUser=appUserService.getAppUserByUserDetail();
        feedback.setFrom(appUser);
        return save(feedback);
    }




}

