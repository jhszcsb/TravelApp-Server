package backend.service;

import backend.entity.Places;
import backend.repository.PlacesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlacesService {

    @Resource
    private PlacesRepository placesRepository;

    public Places createNewForTrip(int trip_id) {
        return null;
    }

    @Transactional
    public List findAll() {
        return placesRepository.findAll();
    }

    public List<Places> findAllForTrip(int trip_id) {
        return placesRepository.findByTrip_id(trip_id);
    }
}
