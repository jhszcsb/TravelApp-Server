package backend.entity;

import javax.persistence.*;

@Entity(name = "friendship_data")
public class FriendshipData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
