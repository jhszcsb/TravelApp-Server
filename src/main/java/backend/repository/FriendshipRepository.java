package backend.repository;

import backend.entity.FriendshipData;
import backend.entity.Traveler;

import java.util.List;

public interface FriendshipRepository extends BaseRepository<FriendshipData, Integer> {

    List<Traveler> findByTraveler1_id(int id);
}
