package backend.restcontroller;

import backend.entity.Place;
import backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
