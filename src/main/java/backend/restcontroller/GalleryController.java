package backend.restcontroller;

import backend.entity.Gallery;
import backend.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GalleryController {

    @Autowired
    GalleryService galleryService;

    // READ (for Trip)
    /*@RequestMapping(value="/trips/{trip_id}/gallery", method = RequestMethod.GET)
    public Gallery getGalleryForTrip(@PathVariable int trip_id) {
        return galleryService.findAllForTrip(trip_id);
    }*/
}
