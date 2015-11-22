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

    // READ (for Place)
    @RequestMapping(value="/place/{place_id}/pictures", method = RequestMethod.GET)
    public List<Picture> getAllPicturesForPlace(@PathVariable int place_id) {
        return pictureService.findAllForPlace(place_id);
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

    // todo: create for place

    // todo: set place id


    // DELETE (by id)
    @RequestMapping(value="/pictures/{picture_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePictureById(@PathVariable int id) {
        pictureService.deleteById(id);
    }

}
