package backend.repository;

import backend.entity.FriendshipData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRepository extends JpaRepository<FriendshipData, Integer> {
}
