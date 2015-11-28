package backend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = true, updatable = false)
    private Trip trip;

    @OneToMany(mappedBy = "place", fetch = FetchType.EAGER)
    private List<Picture> pictures = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date arrived;

    @Temporal(TemporalType.TIMESTAMP)
    private Date left;

    public Place() {}

    public Place(int id) {
        this.id = id;
    }

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

    public void setTrip(int trip) {
        this.trip.setId(trip);
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Date getArrived() {
        return arrived;
    }

    public void setArrived(Date arrived) {
        this.arrived = arrived;
    }

    public Date getLeft() {
        return left;
    }

    public void setLeft(Date left) {
        this.left = left;
    }
}
