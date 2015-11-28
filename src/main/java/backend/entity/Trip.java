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
    @JoinColumn(name = "gallery_id", updatable = false)
    private Gallery gallery;

    @OneToMany(mappedBy = "trip", fetch = FetchType.EAGER)
    private List<Place> place = new ArrayList<>();

    private String name;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraveler() {   // return id => solution for not retrieving all traveler data (it would cause infinite loop)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Place> getPlace() {
        return place;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
