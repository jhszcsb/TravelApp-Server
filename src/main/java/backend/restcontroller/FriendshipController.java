package backend.restcontroller;

import backend.entity.FriendshipData;
import backend.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendshipController {

    // todo: use root "/friendships"

    @Autowired
    FriendshipService friendshipService;

    // READ (all)
    @RequestMapping(value="/friendships", method=RequestMethod.GET)
    public List<FriendshipData> getAllFriendshipData() {
        return friendshipService.findAll();
    }

    // READ (Friendships for a Traveler)
    @RequestMapping(value="/friendships/{traveler_id}", method= RequestMethod.GET)
    public List<FriendshipData> getFriendshipsForTraveler(@PathVariable String id) {
        return friendshipService.findForTraveler(id);
    }
}
