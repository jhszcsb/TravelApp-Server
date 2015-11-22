package backend.restcontroller;

import backend.entity.Picture;
import backend.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PictureController {

    @Autowired
    PictureService pictureService;

    // READ (for Places)
    @RequestMapping(value="/places/{places_id}/pictures", method = RequestMethod.GET)
    public List<Picture> getAllPicturesForPlaces(@PathVariable int places_id) {
        return pictureService.findAllForPlaces(places_id);
    }

    // READ (for Gallery)
    @RequestMapping(value="/gallery/{gallery_id}/pictures", method = RequestMethod.GET)
    public List<Picture> getAllPicturesForGallery(@PathVariable int gallery_id) {
        return pictureService.findAllForGallery(gallery_id);
    }

    // todo: findall for trip

}
