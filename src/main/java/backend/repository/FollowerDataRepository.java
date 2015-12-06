package backend.repository;


import backend.entity.FollowerData;
import backend.entity.Traveler;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowerDataRepository extends BaseRepository<FollowerData, Integer> {

    List<Traveler> findByFollower_id(int id);

    void deleteByFollower_idAndFollowed_id(int follower_id, int followed_id);

    @Query(value = "INSERT INTO follower_data (`follower_id`, `followed_id`) VALUES (?1, ?2);", nativeQuery = true)
    @Modifying
    void createNewFollow(int follower_id, int followed_id);

    // improvement: use ids
    @Query(value = "SELECT * FROM follower_data WHERE `follower_id` = ?1 AND `followed_id` = ?2;", nativeQuery = true)
    FollowerData getFollowedData(String follower_name, String followed_name);
}
