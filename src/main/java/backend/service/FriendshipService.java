package backend.service;

import backend.entity.FriendshipData;
import backend.entity.Traveler;
import backend.repository.FriendshipDataRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendshipService {

    @Resource
    private FriendshipDataRepository friendshipDataRepository;

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
}
