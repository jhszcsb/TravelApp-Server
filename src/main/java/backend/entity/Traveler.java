package backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)    // todo: check cascadetypes
    @JoinColumn(name = "personaldata_id")
    private PersonalData personaldata;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "socialdata_id")
    private SocialData socialdata;

    @OneToMany(mappedBy = "traveler", fetch = FetchType.EAGER)    // one traveler, many trips
    // using EAGER fetching to read trips in the same transaction
    private List<Trip> trip = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonalData getPersonaldata() {
        return personaldata;
    }

    public void setPersonaldata(PersonalData personaldata) {
        this.personaldata = personaldata;
    }

    public SocialData getSocialdata() {
        return socialdata;
    }

    public void setSocialdata(SocialData socialdata) {
        this.socialdata = socialdata;
    }

    public List<Trip> getTrip() {
        return trip;
    }

    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }
}
