package backend.restcontroller;

import backend.entity.Picture;
import backend.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    // todo: findAll for trip

    // todo: create for trip

    // CREATE (for gallery)
    @RequestMapping(value="/gallery/{gallery_id}/pictures", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewPictureForGallery(@RequestBody Picture picture) {
        pictureService.createNewForGallery(picture);
    }

    // todo: create for places

    // todo: set places id


    // DELETE (by id)
    @RequestMapping(value="/pictures/{picture_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePictureById(@PathVariable int id) {
        pictureService.deleteById(id);
    }

}
