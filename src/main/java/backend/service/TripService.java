package backend.service;

import backend.entity.Trip;
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
}
