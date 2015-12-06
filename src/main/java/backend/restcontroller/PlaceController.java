package backend.restcontroller;

import backend.entity.Place;
import backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class PlaceController {

    @Autowired
    PlaceService placeService;

    // CREATE (for Trip)
    @RequestMapping(value="/trips/{trip_id}/place", method= RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewPlaceForTrip(@PathVariable int trip_id, @RequestBody Place newPlace) {
        placeService.createNewForTrip(trip_id, newPlace);
    }

    // READ (for Trip)
    @RequestMapping(value="/trips/{trip_id}/place", method=RequestMethod.GET)
    public List<Place> getAllPlaceFoTrip(@PathVariable int trip_id) {
        return placeService.findAllForTrip(trip_id);
    }

    // DELETE (by id)
    @RequestMapping(value="/place/{place_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlaceById(@PathVariable int id) {
        placeService.deleteById(id);
    }

    // HATEOAS Service: After retrieving places for a trip, the API tells the client which methods can be executed:
    // 1. create new place for trip
    // 2. read all places for trip
    // 3. delete place by id

    // READ (for Trip)
    @RequestMapping(value="hateoas/trips/{trip_id}/place", method=RequestMethod.GET)
    public List<Resource<Place>> getAllPlaceForTripHateoas(@PathVariable int trip_id) {
        //return placeService.findAllForTrip(trip_id);
        List<Place> places = placeService.findAllForTrip(trip_id);
        List<Resource<Place>> resources = places.stream().map(this::createPlaceResource).collect(Collectors.toList());
        return resources;
    }

    private Resource<Place> createPlaceResource(Place place) {

        Resource<Place> resource = new Resource<>(place);
        resource.add(linkTo(methodOn(PlaceController.class).getAllPlaceForTripHateoas(place.getTrip())).withSelfRel());
        resource.add(linkTo(methodOn(PlaceController.class).getAllPlaceForTripHateoas(place.getTrip())).withRel("CREATE"));
        resource.add(linkTo(PlaceController.class).slash("trips").slash(place.getId()).slash("place").withRel("READ"));
        resource.add(linkTo(methodOn(TripController.class).getTripById(place.getTrip())).withRel("Trip"));
        System.out.println("id: " + resource.getContent().getId());
        return resource;
    }


    // READ (for Trip)
    @RequestMapping(value="hateoas/one/trips/place/", method=RequestMethod.GET)
    public Resource<Place> getOnePlaceForTripHateoas() {
        //return placeService.findAllForTrip(trip_id);
        Place place = placeService.findAllForTrip(6).get(0);
        Resource<Place> resource = new Resource<>(place);
        resource.add(linkTo(PlaceController.class).slash("trips").slash(place.getId()).slash("place").withRel("READ"));
        resource.add(linkTo(methodOn(TripController.class).getTripById(place.getTrip())).withRel("Trip"));
        System.out.println("id: " + resource.getContent().getId());
        return resource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleErrors(Exception ex, HttpServletResponse response) {
        return new ErrorMessage(String.valueOf(response.getStatus()), ex.getMessage());
    }

}
