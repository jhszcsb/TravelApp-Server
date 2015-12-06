package backend.restcontroller;

import backend.entity.Gallery;
import backend.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GalleryController {

    @Autowired
    GalleryService galleryService;

    // READ (for Trip)
    /*@RequestMapping(value="/trips/{trip_id}/gallery", method = RequestMethod.GET)
    public Gallery getGalleryForTrip(@PathVariable int trip_id) {
        return galleryService.findAllForTrip(trip_id);
    }*/

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage handleErrors(Exception ex, HttpServletResponse response) {
        return new ErrorMessage(String.valueOf(response.getStatus()), ex.getMessage());
    }
}
