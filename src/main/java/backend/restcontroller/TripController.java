package backend.restcontroller;

import backend.entity.*;
import backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    @Autowired
    TripService tripService;

    // CREATE (for Traveler)   // First create a new Trip, then update it with data
    // todo handle wrong input
    @RequestMapping(value="/{traveler_id}/trips", method= RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewTripForTraveler(@PathVariable int traveler_id) {
        tripService.createNewForTraveler(traveler_id);
    }

    // READ (all)
    @RequestMapping(value="/trips", method=RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripService.findAll();
    }

    // READ (all trips for one Traveler)
    @RequestMapping(value="/{traveler_id}/trips", method=RequestMethod.GET)
    public List<Trip> getAllTripsForTraveler(@PathVariable int traveler_id) {
        return tripService.findAllForTraveler(traveler_id);
    }

    // UPDATE (by Traveler id and Trip id)
    // todo: implement

}
