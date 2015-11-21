package backend.service;

import backend.entity.Places;
import backend.repository.PlacesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlacesService {

    @Resource
    private PlacesRepository placesRepository;

    public Places createNewForTrip(int trip_id) {
        return null;
    }
}
