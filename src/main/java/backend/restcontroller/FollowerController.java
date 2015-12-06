package backend.restcontroller;

import backend.entity.FollowerData;
import backend.entity.FollowRequest;
import backend.entity.Traveler;
import backend.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class FollowerController {

    @Autowired
    FollowerService followerService;

    // CREATE (Follow for a Traveler)
    @RequestMapping(value="/follows", method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewFollowForTraveler(@RequestBody FollowRequest request) {
        followerService.createForTraveler(request);
    }

    // READ (all)
    @RequestMapping(value="/follows", method=RequestMethod.GET)
    public List<FollowerData> getAllFollowerData() {
        return followerService.findAll();
    }

    // READ (Follows for a Traveler)
    @RequestMapping(value="/travelers/{traveler_id}/follows", method= RequestMethod.GET)
    public List<Traveler> getFollowsForTraveler(@PathVariable int traveler_id) {
        return followerService.findForTraveler(traveler_id);
    }

    // DELETE (Follow for a Traveler)
    @RequestMapping(value="/travelers/{traveler_id}/follows/{followed_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFollowByTravelerIds(@PathVariable int traveler_id, @PathVariable int followed_id) {
        followerService.deleteByFollowedId(traveler_id, followed_id);
    }


    // HATEOAS Services:

    // CREATE (Follow for a Traveler)
    @RequestMapping(value="/hateoas/follows", method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Resource<Object> createNewFollowForTravelerHateoas(@RequestBody FollowRequest request) {
        followerService.createForTraveler(request);
        Object o = new Object();
        Resource<Object> resource = new Resource(o);
        resource.add(linkTo(methodOn(FollowerController.class).getAllFollowerDataHateoas()).withSelfRel());
        return resource;
    }

    // READ (all)
    @RequestMapping(value="/hateoas/follows", method=RequestMethod.GET)
    public List<Resource<FollowerData>> getAllFollowerDataHateoas() {
        List<FollowerData> followerDatas = followerService.findAll();
        List<Resource<FollowerData>> resources = followerDatas.stream().map(this::createFollowerDataResource).collect(Collectors.toList());
        return resources;
    }

    private Resource<FollowerData> createFollowerDataResource(FollowerData followerData) {
        Resource<FollowerData> resource = new Resource<>(followerData);
        resource.add(linkTo(methodOn(FollowerController.class).getAllFollowerDataHateoas()).withSelfRel());
        // other optional links...
        return resource;
    }

    // READ (Follows for a Traveler)
    @RequestMapping(value="/hateoas/travelers/{traveler_id}/follows", method= RequestMethod.GET)
    public List<Resource<Traveler>> getFollowsForTravelerHateoas(@PathVariable int traveler_id) {
        List<Traveler> travelers = followerService.findForTraveler(traveler_id);
        List<Resource<Traveler>> resources = travelers.stream().map(this::createTravelerResource).collect(Collectors.toList());
        return resources;
    }

    private Resource<Traveler> createTravelerResource(Traveler traveler) {
        Resource<Traveler> resource = new Resource<>(traveler);
        resource.add(linkTo(methodOn(FollowerController.class).getFollowsForTravelerHateoas(traveler.getId())).withSelfRel());
        // other optional links...
        return resource;
    }

    // DELETE (FollowerData for a Traveler)
    @RequestMapping(value="/hateoas/travelers/{traveler_id}/follows/{followed_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Resource<Object> deleteFollowByTravelerIdsHateoas(@PathVariable int traveler_id, @PathVariable int followed_id) {
        followerService.deleteByFollowedId(traveler_id, followed_id);
        Object o = new Object();
        Resource<Object> resource = new Resource(o);
        resource.add(linkTo(methodOn(FollowerController.class).deleteFollowByTravelerIdsHateoas(traveler_id, followed_id)).withSelfRel());
        return resource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleErrors(Exception ex, HttpServletResponse response) {
        return new ErrorMessage(String.valueOf(response.getStatus()), ex.getMessage());
    }
}
