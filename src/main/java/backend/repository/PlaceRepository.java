package backend.repository;

import backend.entity.Place;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceRepository extends BaseRepository<Place, Integer> {

    List<Place> findByTrip_id(int trip_id);

    @Query(value = "INSERT INTO place (`description`, `name`, `trip_id`) VALUES (?1, ?2, ?3);", nativeQuery = true)
    @Modifying
    void saveNewPlaceForTrip(String description, String name, int trip_id);
}
