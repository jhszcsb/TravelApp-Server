package backend.service;

import backend.entity.Trip;
import backend.repository.CommonRepository;
import backend.repository.TripRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TripService {

    @Resource
    private TripRepository tripRepository;

    public void save(Trip newTrip) {
        tripRepository.save(newTrip);
    }

    @Transactional
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public List<Trip> findAllForTraveler(String id) {
        return tripRepository.findByTraveler_id(Integer.parseInt(id));
    }
}
