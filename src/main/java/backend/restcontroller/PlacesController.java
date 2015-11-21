package backend.restcontroller;

import backend.entity.Places;
import backend.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
