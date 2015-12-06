package backend.repository;

import backend.entity.Trip;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends BaseRepository<Trip, Integer> {

    // note: after findBy* the exact db column name has to be used.
    // consider using other column names in the db to have better api
    List<Trip> findByTraveler_id(int id);

    // improvement: optimize query with SQL JOIN
    @Query(value = "select trip from Trip trip, Traveler traveler, FollowerData follower_data, " +
            "PersonalData personal_data where personal_data.username = ?1 and " +
            "traveler.personaldata = personal_data.id and follower_data.follower = traveler.personaldata and " +
            "trip.traveler = follower_data.followed")
    List<Trip> findAllTripsOfFollowedsForTraveler(String name);

    Trip findById(int trip_id);
}
