package backend.service;

import backend.entity.*;
import backend.repository.TripRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TripService {

    @Resource
    private TripRepository tripRepository;

    public Trip createNewForTraveler(int traveler_id) {
        return tripRepository.save(prepareEmptyTripForTraveler(traveler_id));
    }

    @Transactional
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Transactional
    public Trip findById(int trip_id) {
        return tripRepository.findById(trip_id);
    }

    public List<Trip> findAllForTraveler(int id) {
        return tripRepository.findByTraveler_id(id);
    }

    private Trip prepareEmptyTripForTraveler(int id) {
        Trip newTrip = new Trip();
        Traveler traveler = new Traveler();
        traveler.setId(id);
        newTrip.setTraveler(traveler);
        newTrip.setGallery(new Gallery());
        //newTrip.setPlace(new Place());
        newTrip.setTimeline(new Timeline());
        newTrip.setName("new trip");
        return newTrip;
    }

    public List<Trip> findAllTripsOfFollowedsForTraveler(String name) {
        return tripRepository.findAllTripsOfFollowedsForTraveler(name);
    }

    @Transactional
    public void update(Trip updatedTrip) {
        tripRepository.save(updatedTrip);
    }

    public void deleteById(int id) {
        tripRepository.delete(id);
    }

}
