package detail_tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "plumbing_detail")
public class PlumbingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plumbing_det_id", nullable = false)
    private int plumbingDetId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @JoinColumn(name = "plumbing_fixture_id", nullable = false)
    private PlumbingFixtureLkp plumbingFixture;

    @Column(name = "brand", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'n/a'")
    private String brand = "n/a";

    @Column(name = "model", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'n/a'")
    private String model = "n/a";

    @Column(name = "location", nullable = false)
    private String location;

    // getters and setters
    public int getPlumbingDetId() {
        return plumbingDetId;
    }

    public void setPlumbingDetId(int plumbingDetId) {
        this.plumbingDetId = plumbingDetId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public PlumbingFixtureLkp getPlumbingFixture() {
        return plumbingFixture;
    }

    public void setPlumbingFixture(PlumbingFixtureLkp plumbingFixture) {
        this.plumbingFixture = plumbingFixture;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}