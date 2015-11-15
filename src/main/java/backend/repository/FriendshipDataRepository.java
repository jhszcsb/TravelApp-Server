package backend.repository;


import backend.entity.FriendshipData;
import backend.entity.Traveler;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FriendshipDataRepository extends BaseRepository<FriendshipData, Integer> {

    List<Traveler> findByTraveler1_id(int id);

    void deleteByTraveler1_idAndTraveler2_id(int traveler1_id, int traveler2_id);

    @Query(value = "INSERT INTO friendship_data (`traveler1_id`, `traveler2_id`) VALUES (?1, ?2);", nativeQuery = true)
    @Modifying
    void createNewFriendship(int traveler1_id, int traveler2_id);
}
