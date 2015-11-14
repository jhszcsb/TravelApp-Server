package backend.repository;

import backend.entity.Trip;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripRepository extends BaseRepository<Trip, Integer> {

    List<Trip> findByTraveler_id(int id);   // note: after findBy* the exact db column name has to be used. consider using other column names in the db to have better api

    // todo: optimize query
    @Query(value = "select trip from Trip trip, Traveler traveler, FriendshipData friendship_data, " +
            "PersonalData personal_data where personal_data.username = ?1 and " +
            "traveler.personaldata = personal_data.id and friendship_data.traveler1 = traveler.personaldata and " +
            "trip.traveler = friendship_data.traveler2")
    List<Trip> findAllTripsOfFriendsForTraveler(String name);
}
