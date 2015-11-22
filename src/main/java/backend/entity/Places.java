package backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Places {   // todo: rename to Place

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = true, updatable = false)
    private Trip trip;

    @OneToMany(mappedBy = "places", fetch = FetchType.EAGER)
    private List<Picture> pictures = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTrip() {
        return trip.getId();
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
