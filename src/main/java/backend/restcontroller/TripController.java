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

    // CREATE
    @RequestMapping(value="/trips", method= RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewTrip(@RequestBody Trip newTrip) {
        tripService.save(createDummyTrip());
        //tripService.save(newTrip);
    }

    // READ (all)
    @RequestMapping(value="/trips", method=RequestMethod.GET)
    public List<Trip> getAllTrips() {
        return tripService.findAll();
    }

    // READ (all trips for one Traveler)
    // todo: implement this
    /*@RequestMapping(value="/trips/{traveler_id}", method=RequestMethod.GET)
    public List<Trip> getAllTripsForTraveler() {
        return tripService.findAllForTraveler();
    }*/

    private Trip createDummyTrip() {   // todo: extract to separate class
        Trip newTrip = new Trip();
        Traveler traveler = new Traveler();
        traveler.setId(1);
        newTrip.setTraveler(traveler);
        newTrip.setGallery(new Gallery());
        newTrip.setPlaces(new Places());
        newTrip.setTimeline(new Timeline());
        return newTrip;
    }


}
