package backend.repository;


import backend.entity.FollowerData;
import backend.entity.Traveler;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowerDataRepository extends BaseRepository<FollowerData, Integer> {

    List<Traveler> findByTraveler1_id(int id);

    void deleteByTraveler1_idAndTraveler2_id(int traveler1_id, int traveler2_id);

    @Query(value = "INSERT INTO follower_data (`traveler1_id`, `traveler2_id`) VALUES (?1, ?2);", nativeQuery = true)
    @Modifying
    void createNewFollow(int traveler1_id, int traveler2_id);
}
