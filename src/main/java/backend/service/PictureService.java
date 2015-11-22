package backend.service;

import backend.entity.Picture;
import backend.repository.PictureRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PictureService {

    @Resource
    private PictureRepository pictureRepository;

    @Transactional
    public List<Picture> findAllForPlaces(int places_id) {
        return pictureRepository.findByPlaces_id(places_id);
    }

    @Transactional
    public List<Picture> findAllForGallery(int gallery_id) {
        return pictureRepository.findByGallery_id(gallery_id);
    }

    @Transactional
    public void createNewForGallery(Picture picture) {
        pictureRepository.save(picture);
    }

    public void deleteById(int id) {
        pictureRepository.delete(id);
    }
}
