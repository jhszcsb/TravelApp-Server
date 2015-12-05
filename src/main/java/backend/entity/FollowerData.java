package backend.entity;

import javax.persistence.*;

@Entity
@Table(name="follower_data")
public class FollowerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne // cascadetype?
    @JoinColumn(name = "follower_id")
    private Traveler follower;

    @OneToOne // cascadetype?
    @JoinColumn(name = "followed_id")
    private Traveler followed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Traveler getFollower() {
        return follower;
    }

    public void setFollower(Traveler follower) {
        this.follower = follower;
    }

    public Traveler getFollowed() {
        return followed;
    }

    public void setFollowed(Traveler followed) {
        this.followed = followed;
    }
}
