package detail_tracker.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "finish_detail")
public class FinishDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finish_det_id", nullable = false)
    private int finishDetId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "brand", nullable = false)
    private String brand = "n/a";

    @Column(name = "color_pattern", nullable = false)
    private String colorPattern = "n/a";

    @Enumerated(EnumType.STRING)
    @Column(name = "sheen", nullable = false)
    private Sheen sheen = Sheen.N_A;

    // getters and setters
    public int getFinishDetId() {
        return finishDetId;
    }

    public void setFinishDetId(int finishDetId) {
        this.finishDetId = finishDetId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColorPattern() {
        return colorPattern;
    }

    public void setColorPattern(String colorPattern) {
        this.colorPattern = colorPattern;
    }

    public Sheen getSheen() {
        return sheen;
    }

    public void setSheen(Sheen sheen) {
        this.sheen = sheen;
    }
}

enum Sheen {
    N_A, GLOSS, EGGSHELL, SATIN, MATTE
}
