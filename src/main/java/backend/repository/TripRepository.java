package backend.repository;

import backend.entity.Trip;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends BaseRepository<Trip, Integer> {

    // note: after findBy* the exact db column name has to be used.
    // consider using other column names in the db to have better api
    List<Trip> findByTraveler_id(int id);

    // todo: optimize query with SQL JOIN
    @Query(value = "select trip from Trip trip, Traveler traveler, FollowerData follower_data, " +
            "PersonalData personal_data where personal_data.username = ?1 and " +
            "traveler.personaldata = personal_data.id and follower_data.traveler1 = traveler.personaldata and " +
            "trip.traveler = follower_data.traveler2")
    List<Trip> findAllTripsOfFollowedsForTraveler(String name);

    Trip findById(int trip_id);

    /*
    using named parameters:
    http://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html
     */
}
