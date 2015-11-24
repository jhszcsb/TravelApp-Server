package backend.restcontroller;

import backend.entity.FriendshipData;
import backend.entity.PersonalData;
import backend.entity.SocialData;
import backend.entity.Traveler;
import backend.service.TravelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TravelerController {

    // todo: use root "/travelers"

    @Autowired
    TravelerService travelerService;

    /* CRUD FUNCTIONALITY */

    // CREATE
    @RequestMapping(value="/travelers", method=RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewTraveler(@RequestBody Traveler newTraveler) {
        // todo maybe invoke some validation methods here?
        // todo: if socialdata is null, add empty socialdata
        newTraveler.getPersonaldata().setMembersince(new Date());
        travelerService.save(newTraveler);
    }

    // READ (all)
    @RequestMapping(value="/travelers", method=RequestMethod.GET)
    public List<Traveler> getAllTravelers() {
        return travelerService.findAll();
    }

    // READ (by id)
    @RequestMapping(value="/travelers/{id}", method=RequestMethod.GET)
    public Traveler getTravelerById(@PathVariable int id) {
        return travelerService.findById(id);
    }

    // READ (by personaldataid)
    @RequestMapping(value="/travelers/personaldata/{id}", method=RequestMethod.GET)
    // todo: change scope to: /travelers/personaldata/{personaldataid}
    public Traveler getTravelerByPersonalDataId(@PathVariable int id) {
        return travelerService.findByPersonalDataId(id);
    }

    // READ (by name) // todo: add personaldata controller?
    @RequestMapping(value="/travelers/{name}/personaldata", method=RequestMethod.GET)
    public PersonalData getPersonalDataByName(@PathVariable String name) {
        return travelerService.findByUsername(name);
    }

    /*@RequestMapping(value="/travelers/{name}/personaldata", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<PersonalData> getPersonalDataByNameHateoasTest(@PathVariable String name) {
        PersonalData personalData = travelerService.findByUsername(name);
        Resource<PersonalData> resource = new Resource(personalData);
        resource.add(linkTo(methodOn(TravelerController.class).getPersonalDataByNameHateoasTest(name)).withSelfRel());
        return resource;
    }*/

    // UPDATE (by id)
    @RequestMapping(value="/travelers", method=RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTraveler(@RequestBody Traveler updatedTraveler) {
        travelerService.update(updatedTraveler);
    }

    // UPDATE (by name)
    @RequestMapping(value="/travelers/personaldata/{personaldataid}", method=RequestMethod.PUT, consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePersonalDataByName(@RequestBody PersonalData personalData, @PathVariable int personaldataid) {
        travelerService.updatePersonalData(personalData);
    }

    // DELETE (by id)
    @RequestMapping(value="/travelers/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTravelerById(@PathVariable int id) {
        travelerService.deleteById(id);
    }

    private Traveler prepareEmptyTraveler() {
        Traveler traveler = new Traveler();
        PersonalData personalData = new PersonalData();
        SocialData socialData = new SocialData();
        personalData.setMembersince(new Date());
        traveler.setPersonaldata(personalData);
        traveler.setSocialdata(socialData);
        return traveler;
    }

    private Traveler createDummyTraveler() {
        Traveler testDummyTraveler = prepareEmptyTraveler();
        testDummyTraveler.getPersonaldata().setEmail("dummy@traveler.tr");
        testDummyTraveler.getPersonaldata().setUsername("dummyusername");
        testDummyTraveler.getPersonaldata().setFirstname("Dummy");
        testDummyTraveler.getPersonaldata().setLastname("Traveler");
        testDummyTraveler.getPersonaldata().setPassword("secret");
        testDummyTraveler.getPersonaldata().setHometown("hometown");
        return testDummyTraveler;
    }

}
