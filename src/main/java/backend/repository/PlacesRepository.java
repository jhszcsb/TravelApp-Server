package backend.repository;

import backend.entity.Places;

import java.util.List;

public interface PlacesRepository extends BaseRepository<Places, Integer> {

    List<Places> findByTrip_id(int trip_id);
}
