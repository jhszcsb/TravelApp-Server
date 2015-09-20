package backend.service;

import backend.entity.FriendshipData;
import backend.entity.Traveler;
import backend.repository.CommonRepository;
import backend.repository.FriendshipRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendshipService {

    @Resource
    private FriendshipRepository friendshipRepository;

    public List<Traveler> findForTraveler(String id) {
        //return commonRepository.findFriendshipsForTraveler(id);
        return friendshipRepository.findByTraveler1_id(Integer.parseInt(id));
    }

    public List<FriendshipData> findAll() {
        return friendshipRepository.findAll();
    }

    public void deleteByFriendId(String traveler, String friend) {  // not working
        friendshipRepository.deleteByTraveler1_idAndTraveler2_id(Integer.parseInt(traveler), Integer.parseInt(friend));
    }
}
