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

    public void deleteById(String traveler, String friend) {
        //todo implement
    }
}
