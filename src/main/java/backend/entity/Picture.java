package backend.entity;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "gallery_id", nullable = true, updatable = false)
    private Gallery gallery;

    @ManyToOne
    @JoinColumn(name = "places_id", nullable = true, updatable = false)
    private Places places;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGallery() {
        return gallery.getId();
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public int getPlaces() {
        return places.getId();
    }

    public void setPlaces(Places places) {
        this.places = places;
    }
}
