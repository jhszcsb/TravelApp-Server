package backend.restcontroller;

import backend.entity.Picture;
import backend.entity.Traveler;
import backend.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

    // improvement: findAll for trip

    // improvement: create for trip

    // CREATE (for gallery)
    @RequestMapping(value="/gallery/{gallery_id}/pictures", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewPictureForGallery(@RequestBody Picture picture) {
        pictureService.createNewForGallery(picture);
    }

    // imprvement: create for place

    // improvement: set place id?


    // DELETE (by id)
    @RequestMapping(value="/pictures/{picture_id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePictureById(@PathVariable int id) {
        pictureService.deleteById(id);
    }




    // HATEOAS services:

    // READ (for Place)
    @RequestMapping(value="/hateoas/place/{place_id}/pictures", method = RequestMethod.GET)
    public List<Resource<Picture>> getAllPicturesForPlaceHateoas(@PathVariable int place_id) {
        List<Picture> pictures = pictureService.findAllForPlace(place_id);
        List<Resource<Picture>> resources = new ArrayList<>();
        pictures.forEach(this::createPictureResourcePlace);
        return resources;
    }

    private Resource<Picture> createPictureResourcePlace(Picture picture) {
        Resource<Picture> resource = new Resource<>(picture);
        resource.add(linkTo(methodOn(PictureController.class).getAllPicturesForPlaceHateoas(picture.getPlace())).withSelfRel());
        // other optional links...
        return resource;
    }

    private Resource<Picture> createPictureResourceGallery(Picture picture) {
        Resource<Picture> resource = new Resource<>(picture);
        resource.add(linkTo(methodOn(PictureController.class).getAllPicturesForGalleryHateoas(picture.getGallery())).withSelfRel());
        // other optional links...
        return resource;
    }

    // READ (for Gallery)
    @RequestMapping(value="/hateoas/gallery/{gallery_id}/pictures", method = RequestMethod.GET)
    public List<Resource<Picture>> getAllPicturesForGalleryHateoas(@PathVariable int gallery_id) {
        List<Picture> pictures = pictureService.findAllForGallery(gallery_id);
        List<Resource<Picture>> resources = new ArrayList<>();
        pictures.forEach(this::createPictureResourceGallery);
        return resources;
    }

    // CREATE (for gallery)
    @RequestMapping(value="/hateoas/gallery/{gallery_id}/pictures", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Resource<Object> createNewPictureForGalleryHateoas(@RequestBody Picture picture) {
        pictureService.createNewForGallery(picture);
        Object o = new Object();
        Resource<Object> resource = new Resource(o);
        resource.add(linkTo(methodOn(PictureController.class).getAllPicturesForPlaceHateoas(picture.getPlace())).withSelfRel());
        resource.add(linkTo(methodOn(PictureController.class).getAllPicturesForGalleryHateoas(picture.getGallery())).withSelfRel());
        return resource;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleErrors(Exception ex, HttpServletResponse response) {
        return new ErrorMessage(String.valueOf(response.getStatus()), ex.getMessage());
    }

}
