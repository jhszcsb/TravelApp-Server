package backend.repository;

import backend.entity.Traveler;

public interface TravelerRepository extends BaseRepository<Traveler, Integer>{

    Traveler findByPersonaldata_id(int id);

}
