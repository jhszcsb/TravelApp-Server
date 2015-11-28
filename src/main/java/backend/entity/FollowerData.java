package backend.entity;

import javax.persistence.*;

@Entity
@Table(name="follower_data")
public class FollowerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne // cascadetype?
    @JoinColumn(name = "traveler1_id")
    private Traveler traveler1;

    @OneToOne // cascadetype?
    @JoinColumn(name = "traveler2_id")
    private Traveler traveler2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Traveler getTraveler1() {
        return traveler1;
    }

    public void setTraveler1(Traveler traveler1) {
        this.traveler1 = traveler1;
    }

    public Traveler getTraveler2() {
        return traveler2;
    }

    public void setTraveler2(Traveler traveler2) {
        this.traveler2 = traveler2;
    }
}
