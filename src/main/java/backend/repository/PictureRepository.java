package backend.repository;


import backend.entity.Picture;
import java.util.List;

public interface PictureRepository extends BaseRepository<Picture, Integer> {

    List<Picture> findByPlaces_id(int places_id);

    List<Picture> findByGallery_id(int gallery_id);

}
