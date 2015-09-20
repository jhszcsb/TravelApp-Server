package backend.restcontroller;

import backend.entity.FriendshipData;
import backend.entity.Traveler;
import backend.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendshipController {

    // todo: use root "/friendships"

    @Autowired
    FriendshipService friendshipService;

    // CREATE (Friendship for a Traveler)
    // todo implement

    // READ (all)
    @RequestMapping(value="/friendships", method=RequestMethod.GET)
    public List<FriendshipData> getAllFriendshipData() {
        return friendshipService.findAll();
    }

    // READ (Friendships for a Traveler)
    @RequestMapping(value="/{traveler_id}/friendships", method= RequestMethod.GET)
    public List<Traveler> getFriendshipsForTraveler(@PathVariable String traveler_id) {
        return friendshipService.findForTraveler(traveler_id);
    }

    // DELETE (Friendship for a Traveler)
    @RequestMapping(value="/{traveler_id}/friendships/{friend_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFriendshipByTravelerIds(@PathVariable String traveler_id, @PathVariable String friend_id) {
        friendshipService.deleteByFriendId(traveler_id, friend_id);
    }
}
