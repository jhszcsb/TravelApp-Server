package backend.restcontroller;

import backend.entity.*;
import backend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TripController {

    // todo: use root "/trips"

    @Autowired
    TripService tripService;

    // CREATE (for Traveler)   // First create a new Trip, then update it with data
    // todo handle wrong input
    @RequestMapping(value="/{traveler_id}/trips", method= RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewTripForTraveler(@PathVariable String traveler_id) {
        tripService.save(prepareEmptyTripForTraveler(traveler_id));
    }

    // READ (all)
    @RequestMapping(value="/trips", method=RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripService.findAll();
    }

    // READ (all trips for one Traveler)
    @RequestMapping(value="/{traveler_id}/trips", method=RequestMethod.GET)
    public List<Trip> getAllTripsForTraveler(@PathVariable String traveler_id) {
        return tripService.findAllForTraveler(traveler_id);
    }

    private Trip prepareEmptyTripForTraveler(String id) {    // todo rename to prepare...
        Trip newTrip = new Trip();
        Traveler traveler = new Traveler();
        traveler.setId(Integer.parseInt(id));
        newTrip.setTraveler(traveler);
        newTrip.setGallery(new Gallery());
        newTrip.setPlaces(new Places());
        newTrip.setTimeline(new Timeline());
        return newTrip;
    }

    private Trip createDummyTrip() {   // todo: extract to separate class
        return prepareEmptyTripForTraveler("1");
    }

}
