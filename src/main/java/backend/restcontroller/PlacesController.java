package backend.restcontroller;

import backend.entity.Places;
import backend.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlacesController {

    @Autowired
    PlacesService placesService;

    // CREATE (for Trip)
    @RequestMapping(value="/trips/{trip_id}/places", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Places createNewPlaceForTrip(@PathVariable int trip_id, @RequestBody Places newTrip) {
        return placesService.createNewForTrip(trip_id);
    }

    // READ (for Trip)
    @RequestMapping(value="/trips/{trip_id}/places", method=RequestMethod.GET)
    public List<Places> getAllPlacesFoTrip(@PathVariable int trip_id) {
        return placesService.findAllForTrip(trip_id);
    }

    // DELETE (by id)
    @RequestMapping(value="/places/{places_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlacesById(@PathVariable int id) {
        placesService.deleteById(id);
    }
}
