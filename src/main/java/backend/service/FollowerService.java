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
        return followerDataRepository.findByFollower_id(id);
    }

    public List<FollowerData> findAll() {
        return followerDataRepository.findAll();
    }

    public void deleteByFollowedId(int follower, int followed) {  // not working
        followerDataRepository.deleteByFollower_idAndFollowed_id(follower, followed);
    }

    @Transactional
    public String createForTraveler(FollowRequest request) {
        // check for already existing Follow
        if(isAlreadyFollowed(request)) {
            return "Already Followed!";
        }
        PersonalData followerPersonalData = personalDataRepository.findByUsername(request.getFollower());
        PersonalData followedPersonalData = personalDataRepository.findByUsername(request.getFollowed());
        Traveler follower = travelerRepository.findByPersonaldata_id(followerPersonalData.getId());
        Traveler followed = travelerRepository.findByPersonaldata_id(followedPersonalData.getId());
        followerDataRepository.createNewFollow(follower.getId(), followed.getId());
        return "Followed";
    }

    private boolean isAlreadyFollowed(FollowRequest request) {
        // todo: implement using ids
        /*if(followerDataRepository.getFollowedData(request.getTraveler1_name(), request.getTraveler2_name()) != null) {
            return true;
        }*/
        return false;
    }

}
