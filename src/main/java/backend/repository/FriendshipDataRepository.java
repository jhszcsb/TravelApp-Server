package backend.repository;


import backend.entity.FriendshipData;
import backend.entity.Traveler;

import java.util.List;

//TODO: use this instead of friendshiprepository!!!
public interface FriendshipDataRepository extends BaseRepository<FriendshipData, Integer> {

    List<Traveler> findByTraveler1_id(int id);

    void deleteByTraveler1_idAndTraveler2_id(int traveler1_id, int traveler2_id);
}
