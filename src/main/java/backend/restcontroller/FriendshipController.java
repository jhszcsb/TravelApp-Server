package backend.restcontroller;

import backend.entity.FriendshipData;
import backend.entity.FriendshipRequest;
import backend.entity.Traveler;
import backend.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FriendshipController {

    @Autowired
    FriendshipService friendshipService;

    // CREATE (Friendship for a Traveler)
    @RequestMapping(value="/friendships", method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewFriendshipForTraveler(@RequestBody FriendshipRequest request) {
        friendshipService.createForTraveler(request);
    }

    // READ (all)
    @RequestMapping(value="/friendships", method=RequestMethod.GET)
    public List<FriendshipData> getAllFriendshipData() {
        return friendshipService.findAll();
    }

    // READ (Friendships for a Traveler)
    @RequestMapping(value="/{traveler_id}/friendships", method= RequestMethod.GET)
    public List<Traveler> getFriendshipsForTraveler(@PathVariable int traveler_id) {
        return friendshipService.findForTraveler(traveler_id);
    }

    // DELETE (Friendship for a Traveler)
    @RequestMapping(value="/{traveler_id}/friendships/{friend_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFriendshipByTravelerIds(@PathVariable int traveler_id, @PathVariable int friend_id) {
        friendshipService.deleteByFriendId(traveler_id, friend_id);
    }
}
