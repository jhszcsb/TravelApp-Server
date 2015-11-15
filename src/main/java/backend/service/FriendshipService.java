package backend.service;

import backend.entity.FriendshipData;
import backend.entity.FriendshipRequest;
import backend.entity.PersonalData;
import backend.entity.Traveler;
import backend.repository.FriendshipDataRepository;
import backend.repository.PersonalDataRepository;
import backend.repository.TravelerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FriendshipService {

    @Resource
    private FriendshipDataRepository friendshipDataRepository;

    @Resource
    private PersonalDataRepository personalDataRepository;

    @Resource
    TravelerRepository travelerRepository;

    public List<Traveler> findForTraveler(int id) {
        //return commonRepository.findFriendshipsForTraveler(id);
        return friendshipDataRepository.findByTraveler1_id(id);
    }

    public List<FriendshipData> findAll() {
        return friendshipDataRepository.findAll();
    }

    public void deleteByFriendId(int traveler, int friend) {  // not working
        friendshipDataRepository.deleteByTraveler1_idAndTraveler2_id(traveler, friend);
    }

    @Transactional
    public void createForTraveler(FriendshipRequest request) {
        // todo: check for already existing friendship
        PersonalData personalData1 = personalDataRepository.findByUsername(request.getTraveler1_name());
        PersonalData personalData2 = personalDataRepository.findByUsername(request.getTraveler2_name());
        Traveler traveler1 = travelerRepository.findByPersonaldata_id(personalData1.getId());
        Traveler traveler2 = travelerRepository.findByPersonaldata_id(personalData2.getId());
        friendshipDataRepository.createNewFriendship(traveler1.getId(), traveler2.getId());
    }
}
