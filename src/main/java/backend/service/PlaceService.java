package backend.service;

import backend.entity.Place;
import backend.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlaceService {

    @Resource
    private PlaceRepository placeRepository;

    @Transactional
    public void createNewForTrip(int trip_id, Place place) {
        placeRepository.saveNewPlaceForTrip(place.getName(), place.getDescription(),trip_id);
    }

    @Transactional
    public List findAll() {
        return placeRepository.findAll();
    }

    public List<Place> findAllForTrip(int trip_id) {
        return placeRepository.findByTrip_id(trip_id);
    }

    public void deleteById(int id) {
        placeRepository.delete(id);
    }
}
