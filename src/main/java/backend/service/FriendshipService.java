package backend.service;

import backend.entity.FriendshipData;
import backend.repository.FriendshipRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FriendshipService {

    @Resource
    private FriendshipRepository friendshipRepository;

    public List<FriendshipData> findForTraveler(String id) {
        return null;
    }

    public List<FriendshipData> findAll() {
        return friendshipRepository.findAll();
    }
}
