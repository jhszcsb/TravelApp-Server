package backend.service;

import backend.entity.Gallery;
import backend.repository.GalleryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service
public class GalleryService {

    @Resource
    private GalleryRepository galleryRepository;

    /*@Transactional
    public Gallery findAllForTrip(int trip_id) {
        return galleryRepository.findByTrip_id(trip_id);
    }*/
}
