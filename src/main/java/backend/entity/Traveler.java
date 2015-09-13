package backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Traveler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "personaldata_id")
    private PersonalData personaldata;

    @OneToOne
    @JoinColumn(name = "socialdata_id")
    private SocialData socialdata;

    @OneToOne
    @JoinColumn(name = "friendshipdata_id")
    private FriendshipData friendshipdata;

    @OneToMany(mappedBy = "traveler", fetch = FetchType.EAGER)    // one traveler, many trips
    //@JsonIgnore   // using EAGER fetching to read trips in the same transaction
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

    public FriendshipData getFriendshipdata() {
        return friendshipdata;
    }

    public void setFriendshipdata(FriendshipData friendshipdata) {
        this.friendshipdata = friendshipdata;
    }

    public List<Trip> getTrip() {
        return trip;
    }

    public void setTrip(List<Trip> trip) {
        this.trip = trip;
    }
}
