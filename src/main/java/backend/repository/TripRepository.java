package backend.repository;

import backend.entity.Trip;

import java.util.List;

public interface TripRepository extends BaseRepository<Trip, Integer> {

    List<Trip> findByTraveler_id(int id);   // note: after findBy* the exact db column name has to be used. consider using other column names in the db to have better api
}
