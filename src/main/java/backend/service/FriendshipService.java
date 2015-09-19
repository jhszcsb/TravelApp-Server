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

    @Resource
    private CommonRepository commonRepository;

    public List<Traveler> findForTraveler(String id) {
        return commonRepository.findFriendshipsForTraveler(id);
    }

    public List<FriendshipData> findAll() {
        return friendshipRepository.findAll();
    }
}
