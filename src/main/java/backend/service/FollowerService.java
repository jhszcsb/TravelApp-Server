package backend.service;

import backend.entity.FollowerData;
import backend.entity.FollowRequest;
import backend.entity.PersonalData;
import backend.entity.Traveler;
import backend.repository.FollowerDataRepository;
import backend.repository.PersonalDataRepository;
import backend.repository.TravelerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FollowerService {

    @Resource
    private FollowerDataRepository followerDataRepository;

    @Resource
    private PersonalDataRepository personalDataRepository;

    @Resource
    TravelerRepository travelerRepository;

    public List<Traveler> findForTraveler(int id) {
        return followerDataRepository.findByTraveler1_id(id);
    }

    public List<FollowerData> findAll() {
        return followerDataRepository.findAll();
    }

    public void deleteByFollowedId(int traveler, int followed) {  // not working
        followerDataRepository.deleteByTraveler1_idAndTraveler2_id(traveler, followed);
    }

    @Transactional
    public String createForTraveler(FollowRequest request) {
        // todo: check for already existing Follow
        if(isAlreadyFollowed(request)) {
            return "Already Followed!";
        }
        PersonalData personalData1 = personalDataRepository.findByUsername(request.getTraveler1_name());
        PersonalData personalData2 = personalDataRepository.findByUsername(request.getTraveler2_name());
        Traveler traveler1 = travelerRepository.findByPersonaldata_id(personalData1.getId());
        Traveler traveler2 = travelerRepository.findByPersonaldata_id(personalData2.getId());
        followerDataRepository.createNewFollow(traveler1.getId(), traveler2.getId());
        return "Followed";
    }

    private boolean isAlreadyFollowed(FollowRequest request) {
        // todo: use ids
        /*if(followerDataRepository.getFollowedData(request.getTraveler1_name(), request.getTraveler2_name()) != null) {
            return true;
        }*/
        return false;
    }

}
