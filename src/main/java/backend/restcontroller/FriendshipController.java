package backend.restcontroller;

import backend.entity.FriendshipData;
import backend.entity.FriendshipRequest;
import backend.entity.Traveler;
import backend.entity.Trip;
import backend.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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


    // HATEOAS Services:

    // CREATE (Friendship for a Traveler)
    @RequestMapping(value="/hateoas/friendships", method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Resource<Object> createNewFriendshipForTravelerHateoas(@RequestBody FriendshipRequest request) {
        friendshipService.createForTraveler(request);
        Object o = new Object();
        Resource<Object> resource = new Resource(o);
        resource.add(linkTo(methodOn(FriendshipController.class).getAllFriendshipDataHateoas()).withSelfRel());
        return resource;
    }

    // READ (all)
    @RequestMapping(value="/hateoas/friendships", method=RequestMethod.GET)
    public List<Resource<FriendshipData>> getAllFriendshipDataHateoas() {
        List<FriendshipData> friendshipDatas = friendshipService.findAll();
        List<Resource<FriendshipData>> resources = friendshipDatas.stream().map(this::createFriendShipResource).collect(Collectors.toList());
        return resources;
    }

    private Resource<FriendshipData> createFriendShipResource(FriendshipData friendshipData) {
        Resource<FriendshipData> resource = new Resource<>(friendshipData);
        resource.add(linkTo(methodOn(FriendshipController.class).getAllFriendshipDataHateoas()).withSelfRel());
        // other optional links...
        return resource;
    }

    // READ (Friendships for a Traveler)
    @RequestMapping(value="/hateoas/{traveler_id}/friendships", method= RequestMethod.GET)
    public List<Resource<Traveler>> getFriendshipsForTravelerHateoas(@PathVariable int traveler_id) {
        List<Traveler> travelers = friendshipService.findForTraveler(traveler_id);
        List<Resource<Traveler>> resources = travelers.stream().map(this::createTravelerResource).collect(Collectors.toList());
        return resources;
    }

    private Resource<Traveler> createTravelerResource(Traveler traveler) {
        Resource<Traveler> resource = new Resource<>(traveler);
        resource.add(linkTo(methodOn(FriendshipController.class).getFriendshipsForTravelerHateoas(traveler.getId())).withSelfRel());
        // other optional links...
        return resource;
    }

    // DELETE (Friendship for a Traveler)
    @RequestMapping(value="/hateoas/{traveler_id}/friendships/{friend_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Resource<Object> deleteFriendshipByTravelerIdsHateoas(@PathVariable int traveler_id, @PathVariable int friend_id) {
        friendshipService.deleteByFriendId(traveler_id, friend_id);
        Object o = new Object();
        Resource<Object> resource = new Resource(o);
        resource.add(linkTo(methodOn(FriendshipController.class).deleteFriendshipByTravelerIdsHateoas(traveler_id, friend_id)).withSelfRel());
        return resource;
    }
}
