package backend.restcontroller;

import backend.entity.Traveler;
import backend.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravelerController {

    @Autowired
    TravelerService travelerService;

    /* CRUD FUNCTIONALITY */

    // CREATE
    @RequestMapping(value="/travelers", method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewTraveler(@RequestBody Traveler newTraveler) {
        travelerService.save(newTraveler);
    }

    // READ (all)
    @RequestMapping(value="/travelers", method=RequestMethod.GET)
    public List<Traveler> getAllTravelers() {
        return travelerService.findAll();
    }

    // READ (by id)
    @RequestMapping(value="/travelers/{id}", method=RequestMethod.GET)
    public Traveler getTravelerById(@PathVariable String id) {
        return travelerService.findById(id);
    }

    // UPDATE (by id)
    @RequestMapping(value="/travelers", method=RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTraveler(@RequestBody Traveler updatedTraveler) {
        travelerService.update(updatedTraveler);
    }

    // DELETE (by id)
    @RequestMapping(value="/travelers/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTravelerById(@PathVariable String id) {
        travelerService.deleteById(id);
    }

}
