package backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "traveler_id", nullable = true, updatable = false)    // many trips, one traveler
    private Traveler traveler;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeline_id")
    private Timeline timeline;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "places_id")
    private Places places;*/

    @OneToMany(mappedBy = "trip", fetch = FetchType.EAGER)
    private List<Places> places = new ArrayList<>();

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraveler() {   // todo find solution for not retrieving all traveler data (causes infinite loop)
        return traveler.getId();
    }

    public void setTraveler(Traveler traveler) {
        this.traveler = traveler;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    /*public Places getPlaces() {
        return places;
    }

    public void setPlaces(Places places) {
        this.places = places;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Places> getPlaces() {
        return places;
    }

    public void setPlaces(List<Places> places) {
        this.places = places;
    }
}
