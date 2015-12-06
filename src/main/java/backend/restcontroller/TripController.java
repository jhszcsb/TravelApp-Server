package backend.restcontroller;

import backend.entity.*;
import backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TripController {

    // todo: set content type everywhere

    @Autowired
    TripService tripService;

    // CREATE (for Traveler)   // First create a new Trip, then update it with data
    // todo handle wrong input
    @RequestMapping(value="/travelers/{traveler_id}/trips", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Trip createNewTripForTraveler(@PathVariable int traveler_id) {
        return tripService.createNewForTraveler(traveler_id);
    }

    // READ (all)
    @RequestMapping(value="/trips", method=RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripService.findAll();
    }

    // READ (by id)
    @RequestMapping(value="/trips/{trip_id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Trip getTripById(@PathVariable int trip_id) {
        return tripService.findById(trip_id);
    }

    // READ (all trips for one Traveler)
    @RequestMapping(value="/travelers/{traveler_id}/trips", method=RequestMethod.GET)
    public List<Trip> getAllTripsForTraveler(@PathVariable int traveler_id) {
        return tripService.findAllForTraveler(traveler_id);
    }

    // READ (all trips of followeds for one Traveler by name)
    @RequestMapping(value="/{name}/timeline", method=RequestMethod.GET)
    public List<Trip> getAllTripsForTraveler(@PathVariable String name) {
        return tripService.findAllTripsOfFollowedsForTraveler(name);
    }

    // UPDATE
    @RequestMapping(value="/trips", method=RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrip(@RequestBody Trip updatedTrip) {
        tripService.update(updatedTrip);
    }

    // DELETE (by id)
    @RequestMapping(value="/trips/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTravelerById(@PathVariable int id) {
        tripService.deleteById(id);
    }

    // HATEOAS test
    @RequestMapping(value = "/hateoas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource<Trip> getHateoas() {
        Trip trip = tripService.findAllForTraveler(1).get(0);
        Resource<Trip> resource = new Resource(trip);
        resource.add(linkTo(methodOn(TripController.class).getHateoas()).withSelfRel());
        return resource;
    }

    // HATEOAS test for collection
    @RequestMapping(value = "/hateoas/collection", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Resource<Trip>> getHateoasCollection() {
        List<Trip> trips = tripService.findAllForTraveler(1);
        List<Resource<Trip>> resources = new ArrayList<Resource<Trip>>();
        for(Trip trip : trips) {
            resources.add(createTripResource(trip));

        }
        return resources;
    }

    private Resource<Trip> createTripResource(Trip trip) {
        Resource<Trip> resource = new Resource<Trip>(trip);
        resource.add(linkTo(methodOn(TripController.class).getHateoas()).withSelfRel());

        // other optional links...
        //resource.add(linkTo(methodOn(TripController.class). .withRel("..."));
        // Option to purchase Album
        //if (/*something*/) {
        //    resource.add(linkTo(methodOn(TripController.class).doSomething(trip.getId())).withRel("trip.something"));
        //}
        return resource;
    }

    // no HATEOAS test
    @RequestMapping(value = "/nohateoas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Trip getNoHateoas() {
        Trip trip = tripService.findAllForTraveler(1).get(0);
        return trip;
    }

    // UPDATE (by Traveler id and Trip id)
    // todo: implement

}
