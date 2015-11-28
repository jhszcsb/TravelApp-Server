package backend.entity;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Lob
    private byte[] data;

    @ManyToOne()
    @JoinColumn(name = "gallery_id", nullable = true, updatable = false)
    private Gallery gallery;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "place_id", nullable = true, updatable = false)
    private Place place;
    // !!!!!!!!!! TODO: place can not be null, causes error!!!

    /*public Picture(){}

    public Picture(int gallery) {
        this.gallery = ;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getGallery() {
        return gallery.getId();
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }

    public int getPlace() {
        return place.getId();
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
