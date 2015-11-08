package backend.entity;

import javax.persistence.*;

@Entity
@Table(name="social_data")
public class SocialData {

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
