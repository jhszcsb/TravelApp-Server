package backend.repository;

import backend.entity.Place;

import java.util.List;

public interface PlaceRepository extends BaseRepository<Place, Integer> {

    List<Place> findByTrip_id(int trip_id);
}
